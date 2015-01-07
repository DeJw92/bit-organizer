package pl.edu.knbit.organizer.aggregate_roots.project_AR;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.commands.AddTeamMemberCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.commands.CloseTeamMembersRecruitmentCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.commands.CreateProjectCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.commands.OpenTeamMembersRecruitmentCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMember;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.events.*;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.handlers.ProjectCommandHandler;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Created by Dawid Pawlak.
 */

@RunWith(MockitoJUnitRunner.class)
public class ProjectTest {

    private FixtureConfiguration<Project> fixture;
    private ProjectID projectID;
    private ProjectCommandHandler commandHandler;

    @Mock
    private TeamMemberRecruitment teamMemberRecruitment;
    @Mock
    private TeamMember teamMember;

    @Before
    public void setUp() {
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
        fixture.given(new ProjectCreatedEvent(projectID, teamMemberRecruitment))
                .when(new CloseTeamMembersRecruitmentCommand(projectID))
                .expectEvents(new TeamMemberRecruitmentClosedEvent(projectID));
    }

    @Test
    public void addTeamMemberCommandShouldCauseTeamMemberAddedEvent() {
        when(teamMemberRecruitment.isRecruitmentOpen()).thenReturn(true);
        fixture.given(
                    new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                    new TeamMemberRecruitmentOpenEvent(projectID)
        )
                .when(new AddTeamMemberCommand(projectID, teamMember))
                .expectEvents(new TeamMemberAddedEvent(projectID, teamMember));
    }

    @Test
    public void addTeamMemberCommandWhenRecruitmentClosedShouldCauseRecruitmentClosedEvent() {
        when(teamMemberRecruitment.isRecruitmentOpen()).thenReturn(false);
        fixture.given(
                new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                new TeamMemberRecruitmentOpenEvent(projectID)
        )
                .when(new AddTeamMemberCommand(projectID, teamMember))
                .expectEvents(new RecruitmentClosedEvent(projectID));
    }



}
