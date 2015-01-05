package pl.edu.knbit.domain;

import pl.edu.knbit.domain.aggregates.Idea;
import pl.edu.knbit.domain.aggregates.IdeaCommandHandler;
import pl.edu.knbit.domain.commands.CreateIdeaCommand;
import pl.edu.knbit.domain.commands.SelectParentGroupCommand;
import pl.edu.knbit.domain.events.IdeaCreatedEvent;
import pl.edu.knbit.domain.events.ParentGroupSelectedEvent;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
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

    @Before
    public void setUp() throws Exception {
        fixtureConfiguration = Fixtures.newGivenWhenThenFixture(Idea.class);

        ideaId = new IdeaId(UUID.randomUUID());
        groupId = new GroupId("parent group");
        title = "Great idea!";
        description = "Description of great idea";

        IdeaCommandHandler ideaCommandHandler = new IdeaCommandHandler();
        ideaCommandHandler.setIdeaRepository(fixtureConfiguration.getRepository());
        fixtureConfiguration.registerAnnotatedCommandHandler(ideaCommandHandler);
    }

    @Test
    public void testCreateIdea() throws Exception {
        fixtureConfiguration.given()
                .when(new CreateIdeaCommand(ideaId, title, description))
                .expectEvents(new IdeaCreatedEvent(ideaId, title, description));
    }

    @Test
    public void testSelectParentGroup() throws Exception {
        fixtureConfiguration.given(new IdeaCreatedEvent(ideaId, title, description))
                .when(new SelectParentGroupCommand(ideaId, groupId))
                .expectEvents(new ParentGroupSelectedEvent(ideaId, groupId));
    }
}
