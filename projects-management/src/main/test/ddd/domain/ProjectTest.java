package ddd.domain;

import ddd.domain.aggregate_roots.Project;
import ddd.domain.commands.CloseTeamMembersRecruitmentCommand;
import ddd.domain.commands.CreateProjectCommand;
import ddd.domain.commands.OpenTeamMembersRecruitmentCommand;
import ddd.domain.entities.TeamMemberRecruitment;
import ddd.domain.events.ProjectCreatedEvent;
import ddd.domain.events.TeamMembersRecruitmentCloseEvent;
import ddd.domain.events.TeamMembersRecruitmentOpenEvent;
import ddd.domain.handlers.ProjectCommandHandler;
import ddd.domain.value_objects.ProjectID;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Created by Dawid Pawlak.
 */
public class ProjectTest {

    private FixtureConfiguration<Project> fixture;
    private ProjectID projectID;
    private ProjectCommandHandler commandHandler;

    @Mock
    private TeamMemberRecruitment teamMemberRecruitment;
//
//    @Mock
//    private Member member;

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
                .expectEvents(new TeamMembersRecruitmentOpenEvent(projectID));
    }

    @Test
    public void closeTeamMembersRecruitmentCommandShouldCauseTeamMembersRecruitmentCloseEvent() {
        fixture.given(new ProjectCreatedEvent(projectID, teamMemberRecruitment))
                .when(new CloseTeamMembersRecruitmentCommand(projectID))
                .expectEvents(new TeamMembersRecruitmentCloseEvent(projectID));
    }



}
