package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.integration;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.commands.ApplyForTeamLeaderCommand;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.commands.OpenTeamLeaderRecruitmentCommand;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events.CandidateAppliedEvent;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events.TeamLeaderSelectedEvent;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.handlers.TeamLeaderRecruitmentCommandHandler;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.TeamLeaderRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.commands.SelectTeamLeaderCommand;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.entities.Member;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events.TeamLeaderRecruitmentOpenedEvent;

/**
 * Created by Tomasz Chmielarz, Bartosz Zurkowski on 06.01.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class TeamLeaderRecruitmentTest {

    private FixtureConfiguration<TeamLeaderRecruitment> fixture;

    private TeamLeaderRecruitmentId teamLeaderRecruitmentId;

    private TeamLeaderRecruitmentCommandHandler commandHandler;

    @Mock
    private Member candidate;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(TeamLeaderRecruitment.class);
        commandHandler = new TeamLeaderRecruitmentCommandHandler();
        commandHandler.setRepository(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);
        teamLeaderRecruitmentId = new TeamLeaderRecruitmentId(1);
    }

    @Test
    public void openTeamLeaderRecruitmentCommandShouldCauseTeamLeaderRecruitmentOpenedEvent() {
        fixture.given()
                .when(new OpenTeamLeaderRecruitmentCommand(teamLeaderRecruitmentId))
                .expectEvents(new TeamLeaderRecruitmentOpenedEvent(teamLeaderRecruitmentId));
    }

    @Test
    public void applyForTeamLeaderCommandShouldCauseCandidateAppliedEvent() {
        fixture.given(new TeamLeaderRecruitmentOpenedEvent(teamLeaderRecruitmentId))
                .when(new ApplyForTeamLeaderCommand(teamLeaderRecruitmentId, candidate))
                .expectEvents(new CandidateAppliedEvent(teamLeaderRecruitmentId, candidate));
    }

    @Test
    public void selectTeamLeaderCommandShouldCauseTeamLeaderSelectedEvent() throws Exception {
        fixture.given(
                new TeamLeaderRecruitmentOpenedEvent(teamLeaderRecruitmentId),
                new ApplyForTeamLeaderCommand(teamLeaderRecruitmentId, candidate)
        )
                .when(new SelectTeamLeaderCommand(teamLeaderRecruitmentId, candidate))
                .expectEvents(new TeamLeaderSelectedEvent(teamLeaderRecruitmentId, candidate));
    }
}