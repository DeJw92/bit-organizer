package pl.edu.knbit.organizer.aggregate_roots.project.behavioral;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.knbit.organizer.aggregate_roots.project.Project;
import pl.edu.knbit.organizer.aggregate_roots.project.commands.*;
import pl.edu.knbit.organizer.aggregate_roots.project.entities.TeamMember;
import pl.edu.knbit.organizer.aggregate_roots.project.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.project.events.*;
import pl.edu.knbit.organizer.aggregate_roots.project.handlers.ProjectCommandHandler;
import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * @author Dawid Pawlak, Pawel Kolodziejczyk
 */

@RunWith(MockitoJUnitRunner.class)
public class ProjectTest {

    private FixtureConfiguration<Project> fixture;
    private ProjectID projectID;
    private ProjectCommandHandler commandHandler;

    private TeamMemberRecruitment teamMemberRecruitment;

    @Mock
    private TeamMember teamMember;

    @Before
    public void setUp() {
        teamMemberRecruitment = new TeamMemberRecruitment();
        commandHandler = new ProjectCommandHandler();
        fixture = Fixtures.newGivenWhenThenFixture(Project.class);
        fixture.registerAnnotatedCommandHandler(commandHandler);
        commandHandler.setRepository(fixture.getRepository());
        projectID = ProjectID.of("TEST_ID");
    }

    @Test
    public void createProjectCommandShouldCauseCreateProjectEvent() {
        fixture.given()
                .when(new CreateProjectCommand(projectID, teamMemberRecruitment))
                .expectEvents(new ProjectCreatedEvent(projectID, teamMemberRecruitment));
    }

    @Test
    public void openTeamMembersRecruitmentCommandShouldCauseTeamMembersRecruitmentOpenEvent() {
        fixture.given(new ProjectCreatedEvent(projectID, teamMemberRecruitment))
                .when(new OpenTeamMembersRecruitmentCommand(projectID))
                .expectEvents(new TeamMemberRecruitmentOpenEvent(projectID));
    }

    @Test
    public void closeTeamMembersRecruitmentCommandShouldCauseTeamMembersRecruitmentCloseEvent() {
        fixture.given(new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                      new TeamMemberRecruitmentOpenEvent(projectID))
                .when(new CloseTeamMemberRecruitmentCommand(projectID))
                .expectEvents(new TeamMemberRecruitmentClosedEvent(projectID));
    }

    @Test
    public void addTeamMemberCommandShouldCauseTeamMemberAddedEvent() {
        fixture.given(
                new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                new TeamMemberRecruitmentOpenEvent(projectID)
        )
                .when(new AddTeamMemberCommand(projectID, teamMember))
                .expectEvents(new TeamMemberAddedEvent(projectID, teamMember));
    }

    @Test
    public void addTeamMemberCommandWhenRecruitmentClosedShouldCauseRecruitmentClosedEvent() {
        fixture.given(
                new ProjectCreatedEvent(projectID, teamMemberRecruitment)
        )
                .when(new AddTeamMemberCommand(projectID, teamMember))
                .expectEvents(new RecruitmentClosedEvent(projectID));
    }

    @Test
    public void removeTeamMemberCommandShouldCauseMemberRemovedEvent() {
        fixture.given(new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                      new TeamMemberRecruitmentOpenEvent(projectID),
                      new TeamMemberAddedEvent(projectID, teamMember)).
                when(new RemoveTeamMemberCommand(projectID, teamMember)).
                expectEvents(new TeamMemberRemovedEvent(projectID, teamMember));
    }

    @Test
    public void resignFromTeamMemberCommandShouldCauseMemberRemovedEvent() {
        fixture.given(new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                      new TeamMemberRecruitmentOpenEvent(projectID),
                      new TeamMemberAddedEvent(projectID, teamMember)).
                when(new ResignFromTeamMemberCommand(projectID, teamMember)).
                expectEvents(new TeamMemberRemovedEvent(projectID, teamMember));
    }

    @Test
    public void placeProjectInStructureCommandShouldCauseProjectPlacedInStructureEvent() {
        fixture.given(new ProjectCreatedEvent(projectID, teamMemberRecruitment)).
                when(new PlaceProjectInStructureCommand(projectID)).
                expectEvents(new ProjectPlacedInStructureEvent(projectID));
    }

    @Test
    public void addDuplicatedTeamMemberShouldNotCauseTeamMemberAddedEvent() {
        fixture.given(new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                      new TeamMemberRecruitmentOpenEvent(projectID),
                      new TeamMemberAddedEvent(projectID, teamMember)).
                when(new AddTeamMemberCommand(projectID, teamMember)).
                expectEvents();
    }

    @Test
    public void removeNotAddesTeamMemberShouldNotCauseTeamMemberRemovedEvent() {
        fixture.given(new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                new TeamMemberRecruitmentOpenEvent(projectID)).
                when(new RemoveTeamMemberCommand(projectID, teamMember)).
                expectEvents();
    }
}
