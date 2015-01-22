package pl.edu.knbit.organizer.aggregateRoots.projectIdea.behavioral;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.ProjectIdea;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.commands.AcceptTeamLeaderCommand;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.commands.OpenTeamLeaderRecruitmentCommand;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.entities.MemberID;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.events.*;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.handlers.ProjectIdeaCommandHandler;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.valueObjects.ProjectIdeaID;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.valueObjects.TeamLeaderRecruitmentStatus;

public class ProjectIdeaFixtureTest {

    private FixtureConfiguration<ProjectIdea> fixture;

    private ProjectIdeaID projectIdeaID;
    private TeamLeaderRecruitmentStatus status;
    private MemberID teamLeader;
    private String description;

    @Before
    public void setUp() {
        fixture = Fixtures.newGivenWhenThenFixture(ProjectIdea.class);

        ProjectIdeaCommandHandler commandHandler = new ProjectIdeaCommandHandler();
        commandHandler.setProjectIdeaRepository(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);

        projectIdeaID = ProjectIdeaID.of("1");
        teamLeader = new MemberID("2");
        description = "Test";
    }

    @Test
    public void shouldAcceptTeamLeader() {
        fixture.
                given(new ProjectIdeaCreatedEvent(projectIdeaID, description),
                        new TeamLeaderRecruitmentOpenedEvent(projectIdeaID)).
                when(new AcceptTeamLeaderCommand(teamLeader, projectIdeaID)).
                expectEvents(new TeamLeaderAcceptedEvent(teamLeader));
    }

    @Test
    public void shouldNotAllowToAcceptTeamLeaderTwice() {
        fixture.
                given(new ProjectIdeaCreatedEvent(projectIdeaID, description),
                        new TeamLeaderRecruitmentOpenedEvent(projectIdeaID),
                        new TeamLeaderAcceptedEvent(teamLeader)).
                when(new AcceptTeamLeaderCommand(teamLeader, projectIdeaID)).
                expectEvents(new TeamLeaderRecruitmentNotOpenedEvent(teamLeader));
    }

    @Test
    public void shouldOpenTeamLeaderRecruitment() {
        fixture.
                given(new ProjectIdeaCreatedEvent(projectIdeaID, description)).
                when(new OpenTeamLeaderRecruitmentCommand(projectIdeaID)).
                expectEvents(new TeamLeaderRecruitmentOpenedEvent(projectIdeaID));
    }

    @Test
    public void shouldNotAllowToMakeMultipleRecriuitments() {
        fixture.
                given(new ProjectIdeaCreatedEvent(projectIdeaID, description),
                        new TeamLeaderRecruitmentOpenedEvent(projectIdeaID)).
                when(new OpenTeamLeaderRecruitmentCommand(projectIdeaID)).
                expectEvents(new TeamLeaderRecruitmentAlreadyOpenedEvent(projectIdeaID));
    }

}
