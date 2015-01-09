package pl.edu.knbit.organizer;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.organizer.teamrecruitment.MemberId;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitment;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentCommandHandler;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentId;
import pl.edu.knbit.organizer.teamrecruitment.commands.AcceptMemberCommand;
import pl.edu.knbit.organizer.teamrecruitment.commands.ApplyForProjectCommand;
import pl.edu.knbit.organizer.teamrecruitment.commands.CloseTeamRecruitmentCommand;
import pl.edu.knbit.organizer.teamrecruitment.commands.RejectMemberCommand;
import pl.edu.knbit.organizer.teamrecruitment.events.*;

public class TeamRecruitmentTest {

    private FixtureConfiguration<TeamRecruitment> fixture;

    public TeamRecruitmentId teamRecruitmentId;
    public final MemberId memberId = new MemberId(1);

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(TeamRecruitment.class);

        final TeamRecruitmentCommandHandler commandHandler = new TeamRecruitmentCommandHandler();
        commandHandler.setRepository(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);

        teamRecruitmentId = TeamRecruitmentId.randomId();
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

}