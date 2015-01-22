package pl.edu.knbit.domain.idea.aggregates.bus;

import org.axonframework.repository.Repository;
import pl.edu.knbit.domain.utils.InMemoryRepository;
import pl.edu.knbit.domain.member.valueobjects.MemberId;
import pl.edu.knbit.domain.group.aggregates.Group;
import pl.edu.knbit.domain.idea.aggregates.Idea;
import pl.edu.knbit.domain.idea.aggregates.IdeaCommandHandler;
import pl.edu.knbit.domain.idea.commands.*;
import pl.edu.knbit.domain.idea.events.*;
import pl.edu.knbit.domain.idea.exceptions.ParentGroupNotSelectedException;
import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.idea.valueobjects.IdeaId;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class IdeaTest {
    private FixtureConfiguration fixtureConfiguration;
    private IdeaId ideaId;
    private GroupId groupId;
    private String title;
    private String description;
    private MemberId memberId;
    private Repository<Group> groupRepository;
    private Group group;

    @Before
    public void setUp() throws Exception {
        fixtureConfiguration = Fixtures.newGivenWhenThenFixture(Idea.class);

        ideaId = IdeaId.nextId();
        groupId = new GroupId(UUID.randomUUID());
        title = "Great idea!";
        description = "Description of great idea";
        memberId = MemberId.nextId();

        IdeaCommandHandler ideaCommandHandler = new IdeaCommandHandler();
        ideaCommandHandler.setIdeaRepository(fixtureConfiguration.getRepository());
        fixtureConfiguration.registerAnnotatedCommandHandler(ideaCommandHandler);

        groupRepository = new InMemoryRepository<>();
        ideaCommandHandler.setGroupRepository(groupRepository);

        group = new Group(groupId, "group_name", "group_description");
    }

    @Test
    public void testSubmitIdea() throws Exception {
        fixtureConfiguration.given()
                .when(new SubmitIdeaCommand(ideaId, title, description))
                .expectEvents(new IdeaSubmittedEvent(ideaId, title, description));
    }

    @Test
    public void testSelectParentGroup() throws Exception {
        groupRepository.add(group);
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description))
                .when(new SelectParentGroupCommand(ideaId, groupId))
                .expectEvents(new ParentGroupSelectedEvent(ideaId, groupId));
    }

    @Test
    public void testSelectGroupSupervisor() {
        groupRepository.add(group);
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description), new ParentGroupSelectedEvent(ideaId, groupId))
                .when(new SelectGroupSupervisorCommand(ideaId, groupId, memberId))
                .expectEvents(new GroupSupervisorSelectedEvent(ideaId, groupId, memberId));
    }

    @Test
    public void shouldThrowExceptionWhenSelectingGroupSupervisorForIdeaWithoutParentGroup() throws Exception {
        groupRepository.add(group);
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description))
                .when(new SelectGroupSupervisorCommand(ideaId, groupId, memberId))
                .expectException(ParentGroupNotSelectedException.class);

    }

    @Test
    public void testAcceptIdea() throws Exception {
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description))
                .when(new AcceptIdeaCommand(ideaId))
                .expectEvents(new IdeaAcceptedEvent(ideaId));
    }

    @Test
    public void shouldThrowExceptionWhenIdeaAcceptedInWrongState() throws Exception {
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description), new IdeaAcceptedEvent(ideaId))
                .when(new AcceptIdeaCommand(ideaId))
                .expectException(IllegalStateException.class);
    }

    @Test
    public void testRejectIdea() throws Exception {
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description))
                .when(new RejectIdeaCommand(ideaId))
                .expectEvents(new IdeaRejectedEvent(ideaId));
    }

    @Test
    public void shouldThrowExceptionWhenIdeaRejectedInWrongState() throws Exception {
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description), new IdeaAcceptedEvent(ideaId))
                .when(new RejectIdeaCommand(ideaId))
                .expectException(IllegalStateException.class);
    }

    @Test
    public void testAbandonIdea() throws Exception {
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description), new IdeaAcceptedEvent(ideaId))
                .when(new AbandonIdeaCommand(ideaId))
                .expectEvents(new IdeaAbandonedEvent(ideaId));
    }

    @Test
    public void shouldThrowExceptionWhenIdeaAbandonedInWrongState() throws Exception {
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description))
                .when(new AbandonIdeaCommand(ideaId))
                .expectException(IllegalStateException.class);
    }
}