package pl.edu.knbit.domain.aggregates;

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

public class IdeaTest {
    private FixtureConfiguration fixtureConfiguration;
    private IdeaId ideaId;
    private GroupId groupId;
    private String title;
    private String description;
    private UserId userId;

    @Before
    public void setUp() throws Exception {
        fixtureConfiguration = Fixtures.newGivenWhenThenFixture(Idea.class);

        ideaId = IdeaId.nextId();
        groupId = new GroupId(UUID.randomUUID());
        title = "Great idea!";
        description = "Description of great idea";
        userId = UserId.nextId();

        IdeaCommandHandler ideaCommandHandler = new IdeaCommandHandler();
        ideaCommandHandler.setIdeaRepository(fixtureConfiguration.getRepository());
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
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description))
                .when(new SelectParentGroupCommand(ideaId, groupId))
                .expectEvents(new ParentGroupSelectedEvent(ideaId, groupId));
    }

    @Test
    public void testSelectGroupSupervisor() {
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description), new ParentGroupSelectedEvent(ideaId, groupId))
                .when(new SelectGroupSupervisorCommand(ideaId, groupId, userId))
                .expectEvents(new GroupSupervisorSelectedEvent(ideaId, groupId, userId));
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
