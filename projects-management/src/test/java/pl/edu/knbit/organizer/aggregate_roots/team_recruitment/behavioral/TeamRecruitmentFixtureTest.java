package java.pl.edu.knbit.organizer.aggregate_roots.team_recruitment.behavioral;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.TeamRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.commands.*;
import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.events.*;
import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.handlers.TeamRecruitmentCommandHandler;
import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.value_objects.MemberId;
import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.value_objects.TeamRecruitmentId;

public class TeamRecruitmentFixtureTest {

    private FixtureConfiguration<TeamRecruitment> fixture;

    private final TeamRecruitmentId teamRecruitmentId = TeamRecruitmentId.randomId();
    private final MemberId memberId = new MemberId(1);
    private final MemberId secondMemberId = new MemberId(2);

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(TeamRecruitment.class);

        final TeamRecruitmentCommandHandler commandHandler = new TeamRecruitmentCommandHandler();
        commandHandler.setRepository(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);
    }

    @Test
    public void shouldAcceptApplicationsForOpenProject() {
        fixture.given(new TeamRecruitmentOpenedEvent(teamRecruitmentId)).
                when(new ApplyForProjectCommand(teamRecruitmentId, memberId)).
                expectEvents(new MemberAppliedEvent(teamRecruitmentId, memberId));
    }

    @Test
    public void shouldRejectApplicationsForClosedProject() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new TeamRecruitmentClosedEvent(teamRecruitmentId)
                ).
                when(new ApplyForProjectCommand(teamRecruitmentId, memberId)).
                expectException(IllegalStateException.class);
    }

    @Test
    public void shouldNotAllowToApplyTwice() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new MemberAppliedEvent(teamRecruitmentId, memberId)
                ).
                when(new ApplyForProjectCommand(teamRecruitmentId, memberId)).
                expectException(IllegalArgumentException.class);
    }

    @Test
    public void shouldAllowToAcceptAppliedMembers() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new MemberAppliedEvent(teamRecruitmentId, memberId)
                ).
                when(new AcceptMemberCommand(teamRecruitmentId, memberId)).
                expectEvents(new MemberAcceptedEvent(teamRecruitmentId, memberId));
    }

    @Test
    public void shouldNotAllowToAcceptMembersThatDidNotApply() {
        fixture.given(new TeamRecruitmentOpenedEvent(teamRecruitmentId)).
                when(new AcceptMemberCommand(teamRecruitmentId, memberId)).
                expectException(IllegalArgumentException.class);
    }

    @Test
    public void shouldAllowToAcceptMembersWhenRecruitmentClosed() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new MemberAppliedEvent(teamRecruitmentId, memberId),
                        new TeamRecruitmentClosedEvent(teamRecruitmentId)).
                when(new AcceptMemberCommand(teamRecruitmentId, memberId)
                ).
                expectEvents(new MemberAcceptedEvent(teamRecruitmentId, memberId));
    }

    @Test
    public void shouldNotAllowToAcceptMembersWhenRecruitmentFinished() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new MemberAppliedEvent(teamRecruitmentId, memberId),
                        new TeamRecruitmentClosedEvent(teamRecruitmentId),
                        new TeamRecruitmentFinishedEvent(teamRecruitmentId)
                ).
                when(new AcceptMemberCommand(teamRecruitmentId, memberId)).
                expectException(IllegalStateException.class);
    }

    @Test
    public void shouldAllowToCloseOpenEvent() {
        fixture.given(new TeamRecruitmentOpenedEvent(teamRecruitmentId)).
                when(new CloseTeamRecruitmentCommand(teamRecruitmentId)).
                expectEvents(new TeamRecruitmentClosedEvent(teamRecruitmentId));
    }

    @Test
    public void shouldNotAllowToCloseAlreadyClosedEvent() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new TeamRecruitmentClosedEvent(teamRecruitmentId)
                ).
                when(new CloseTeamRecruitmentCommand(teamRecruitmentId)).
                expectException(IllegalStateException.class);
    }

    @Test
    public void shouldNotAllowToCloseFinishedEvent() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new TeamRecruitmentClosedEvent(teamRecruitmentId),
                        new TeamRecruitmentFinishedEvent(teamRecruitmentId)
                ).
                when(new CloseTeamRecruitmentCommand(teamRecruitmentId)).
                expectException(IllegalStateException.class);
    }

    @Test

    public void shouldRejectMembersThatDidApply() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new MemberAppliedEvent(teamRecruitmentId, memberId)
                ).
                when(new RejectMemberCommand(teamRecruitmentId, memberId)).
                expectEvents(new MemberRejectedEvent(teamRecruitmentId, memberId));
    }

    @Test
    public void shouldNotAllowToRejectMembersThatDidNotApply() {
        fixture.given(new TeamRecruitmentOpenedEvent(teamRecruitmentId)).
                when(new RejectMemberCommand(teamRecruitmentId, memberId)).
                expectException(IllegalArgumentException.class);
    }

    @Test
    public void shouldNotAllowToRejectMembersWhenRecruitmentFinished() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new MemberAppliedEvent(teamRecruitmentId, memberId),
                        new TeamRecruitmentFinishedEvent(teamRecruitmentId)
                ).
                when(new RejectMemberCommand(teamRecruitmentId, memberId)).
                expectException(IllegalStateException.class);
    }

    @Test
    public void shouldAllowToFinishOpenRecruitment() {
        fixture.given(new TeamRecruitmentOpenedEvent(teamRecruitmentId))
                .when(new FinishTeamRecruitmentCommand(teamRecruitmentId))
                .expectEvents(new TeamRecruitmentFinishedEvent(teamRecruitmentId));
    }

    @Test
    public void shouldAllowToFinishClosedRecruitment() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new TeamRecruitmentClosedEvent(teamRecruitmentId)
                ).
                when(new FinishTeamRecruitmentCommand(teamRecruitmentId)).
                expectEvents(new TeamRecruitmentFinishedEvent(teamRecruitmentId));
    }

    @Test
    public void shouldAllowToFinishRecruitmentWhenAllMembersAreTakenCareOf() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new MemberAppliedEvent(teamRecruitmentId, memberId),
                        new MemberAppliedEvent(teamRecruitmentId, secondMemberId),
                        new TeamRecruitmentClosedEvent(teamRecruitmentId),
                        new MemberAcceptedEvent(teamRecruitmentId, memberId),
                        new MemberAcceptedEvent(teamRecruitmentId, secondMemberId)
                ).
                when(new FinishTeamRecruitmentCommand(teamRecruitmentId)).
                expectEvents(new TeamRecruitmentFinishedEvent(teamRecruitmentId));
    }

    @Test
    public void shouldNotAllowToFinishRecruitmentUntilAllMembersAreTakenCareOf() {
        fixture.
                given(
                        new TeamRecruitmentOpenedEvent(teamRecruitmentId),
                        new MemberAppliedEvent(teamRecruitmentId, memberId),
                        new MemberAppliedEvent(teamRecruitmentId, secondMemberId),
                        new TeamRecruitmentClosedEvent(teamRecruitmentId),
                        new MemberAcceptedEvent(teamRecruitmentId, secondMemberId)
                ).
                when(new FinishTeamRecruitmentCommand(teamRecruitmentId)).
                expectException(IllegalStateException.class);
    }

}