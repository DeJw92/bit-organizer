package pl.edu.knbit.domain.aggregates;

import org.axonframework.repository.AggregateNotFoundException;
import org.axonframework.repository.Repository;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.knbit.domain.aggregates.group.Group;
import pl.edu.knbit.domain.aggregates.idea.Idea;
import pl.edu.knbit.domain.commands.handlers.IdeaCommandHandler;
import pl.edu.knbit.domain.commands.idea.*;
import pl.edu.knbit.domain.events.idea.*;
import pl.edu.knbit.domain.exceptions.ParentGroupNotSelectedException;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.valueobjects.UserId;

import java.util.UUID;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IdeaTest {
    private FixtureConfiguration fixtureConfiguration;
    private IdeaId ideaId;
    private GroupId groupId;
    private String title;
    private String description;
    private UserId userId;
    private String groupTitle;
    private String groupDescription;
    @Mock
    private Repository<Group> groupRepositoryMock;
    private Group group;

    @Before
    public void setUp() throws Exception {
        fixtureConfiguration = Fixtures.newGivenWhenThenFixture(Idea.class);

        ideaId = IdeaId.nextId();
        groupId = new GroupId(UUID.randomUUID());
        title = "Great idea!";
        description = "Description of great idea";
        userId = UserId.nextId();
        groupTitle = "Group 1";
        groupDescription = "Group 1 description";
        group = new Group(groupId, groupTitle, groupDescription);

        IdeaCommandHandler ideaCommandHandler = new IdeaCommandHandler();
        ideaCommandHandler.setIdeaRepository(fixtureConfiguration.getRepository());
        ideaCommandHandler.setGroupRepository(groupRepositoryMock);
        fixtureConfiguration.registerAnnotatedCommandHandler(ideaCommandHandler);
    }

    @Test
    public void testSubmitIdea() throws Exception {
        fixtureConfiguration.given()
                .when(new SubmitIdeaCommand(ideaId, title, description))
                .expectEvents(new IdeaSubmittedEvent(ideaId, title, description));
    }

    @Test
    public void testSelectParentGroup() throws Exception {
        when(groupRepositoryMock.load(groupId)).thenReturn(group);
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description))
                .when(new SelectParentGroupCommand(ideaId, groupId))
                .expectEvents(new ParentGroupSelectedEvent(ideaId, groupId));
    }

    @Test
    public void shouldThrowExceptionWhenParentGroupToSelectNonExist() throws Exception {
        when(groupRepositoryMock.load(groupId)).thenThrow(AggregateNotFoundException.class);
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description))
                .when(new SelectParentGroupCommand(ideaId, groupId))
                .expectException(AggregateNotFoundException.class);
    }

    @Test
    public void testSelectGroupSupervisor() {
        when(groupRepositoryMock.load(groupId)).thenReturn(group);
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description), new ParentGroupSelectedEvent(ideaId, groupId))
                .when(new SelectGroupSupervisorCommand(ideaId, groupId, userId))
                .expectEvents(new GroupSupervisorSelectedEvent(ideaId, groupId, userId));
    }

    @Test
    public void shouldThrowExceptionWhenGroupSupervisorNonExist() throws Exception {
        when(groupRepositoryMock.load(groupId)).thenThrow(AggregateNotFoundException.class);
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description), new ParentGroupSelectedEvent(ideaId, groupId))
                .when(new SelectGroupSupervisorCommand(ideaId, groupId, userId))
                .expectException(AggregateNotFoundException.class);
    }

    @Test
    public void shouldThrowExceptionWhenSelectingGroupSupervisorForIdeaWithoutParentGroup() throws Exception {
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description))
                .when(new SelectGroupSupervisorCommand(ideaId, groupId, userId))
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
