package pl.edu.knbit.domain;

import pl.edu.knbit.domain.aggregates.Idea;
import pl.edu.knbit.domain.aggregates.IdeaCommandHandler;
import pl.edu.knbit.domain.commands.AcceptIdeaCommand;
import pl.edu.knbit.domain.commands.SubmitIdeaCommand;
import pl.edu.knbit.domain.commands.SelectGroupSupervisorCommand;
import pl.edu.knbit.domain.commands.SelectParentGroupCommand;
import pl.edu.knbit.domain.events.IdeaAcceptedEvent;
import pl.edu.knbit.domain.events.GroupSupervisorSelectedEvent;
import pl.edu.knbit.domain.events.IdeaSubmittedEvent;
import pl.edu.knbit.domain.events.ParentGroupSelectedEvent;
import pl.edu.knbit.domain.exceptions.IdeaAlreadyAcceptedException;
import pl.edu.knbit.domain.exceptions.ParentGroupNotSelectedException;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.valueobjects.UserId;

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
        groupId = new GroupId("parent group");
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
    public void shouldThrowExceptionWhenIdeaAcceptedMoreThanOnce() throws Exception {
        fixtureConfiguration.given(new IdeaSubmittedEvent(ideaId, title, description), new IdeaAcceptedEvent(ideaId))
                .when(new AcceptIdeaCommand(ideaId))
                .expectException(IdeaAlreadyAcceptedException.class);

    }
}
