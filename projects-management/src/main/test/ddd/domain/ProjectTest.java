package ddd.domain;

import ddd.domain.aggregate_roots.Project;
import ddd.domain.commands.AddTeamMemberCommand;
import ddd.domain.commands.CloseTeamMembersRecruitmentCommand;
import ddd.domain.commands.CreateProjectCommand;
import ddd.domain.commands.OpenTeamMembersRecruitmentCommand;
import ddd.domain.entities.Member;
import ddd.domain.entities.TeamMemberRecruitment;
import ddd.domain.events.*;
import ddd.domain.handlers.ProjectCommandHandler;
import ddd.domain.value_objects.ProjectID;
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
    private Member member;

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

    @Test
    public void addTeamMemberCommandShouldCauseTeamMemberAddedEvent() {
        when(teamMemberRecruitment.acceptMember(member)).thenReturn(true);
        when(teamMemberRecruitment.isRecruitmentOpen()).thenReturn(true);
        fixture.given(
                    new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                    new TeamMembersRecruitmentOpenEvent(projectID)
        )
                .when(new AddTeamMemberCommand(projectID, member))
                .expectEvents(new TeamMemberAddedEvent(projectID, member));
    }

    @Test
    public void addTeamMemberCommandWhenRecruitmentClosedShouldCaseRecruitmentClosedEvent() {
        when(teamMemberRecruitment.acceptMember(member)).thenReturn(true);
        when(teamMemberRecruitment.isRecruitmentOpen()).thenReturn(false);
        fixture.given(
                new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                new TeamMembersRecruitmentOpenEvent(projectID)
        )
                .when(new AddTeamMemberCommand(projectID, member))
                .expectEvents(new RecruitmentClosedEvent(projectID));
    }

    @Test
    public void addTeamMemberCommandWhenMemberRejectedShouldCaseMemberRejectedEvent() {
        when(teamMemberRecruitment.acceptMember(member)).thenReturn(false);
        when(teamMemberRecruitment.isRecruitmentOpen()).thenReturn(true);
        fixture.given(
                new ProjectCreatedEvent(projectID, teamMemberRecruitment),
                new TeamMembersRecruitmentOpenEvent(projectID)
        )
                .when(new AddTeamMemberCommand(projectID, member))
                .expectEvents(new MemberRejectedEvent(projectID, member));
    }

}
