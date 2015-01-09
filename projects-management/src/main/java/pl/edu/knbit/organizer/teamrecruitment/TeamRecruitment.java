package pl.edu.knbit.organizer.teamrecruitment;

import com.google.common.base.Preconditions;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.organizer.teamrecruitment.events.*;

import java.util.ArrayList;
import java.util.List;

public class TeamRecruitment extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private TeamRecruitmentId id;
    private List<MemberId> appliedMembers = new ArrayList<>();
    private TeamRecruitmentStatus status = TeamRecruitmentStatus.OPEN;

    private TeamRecruitment() {
    }

    public TeamRecruitment(TeamRecruitmentId id) {
        apply(new TeamRecruitmentOpenedEvent(id));
    }

    public void appointMeeting(MemberId memberId) {
        Preconditions.checkState(status != TeamRecruitmentStatus.FINISHED);

        apply(new MeetingAppointedEvent(id, memberId));
    }

    public void applyForProject(MemberId memberId) {
        Preconditions.checkState(status == TeamRecruitmentStatus.OPEN);

        apply(new MemberAppliedEvent(id, memberId));
    }

    public void acceptMember(MemberId memberId) {
        Preconditions.checkNotNull(memberId);
        Preconditions.checkArgument(appliedMembers.contains(memberId));
        Preconditions.checkState(status != TeamRecruitmentStatus.FINISHED);

        // TODO send command to Project AR
        apply(new MemberAcceptedEvent(id, memberId));
    }

    public void rejectMember(MemberId memberId) {
        Preconditions.checkNotNull(memberId);
        Preconditions.checkArgument(appliedMembers.contains(memberId));
        Preconditions.checkState(status != TeamRecruitmentStatus.FINISHED);

        apply(new MemberRejectedEvent(id, memberId));
    }

    public void closeRecruitment() {
        Preconditions.checkState(status == TeamRecruitmentStatus.OPEN);

        apply(new TeamRecruitmentClosedEvent(id));
    }

    public void finishRecruitment() {
        // TODO Can we finish recruitment that wasn't closed?
        Preconditions.checkState(status != TeamRecruitmentStatus.FINISHED);

        apply(new TeamRecruitmentFinishedEvent(id));
    }

    @EventSourcingHandler
    public void onTeamRecruitmentOpened(TeamRecruitmentOpenedEvent event) {
        id = event.getTeamRecruitmentId();
    }

    @EventSourcingHandler
    public void onMemberApplied(MemberAppliedEvent event) {
        appliedMembers.add(event.getMemberId());
    }

    @EventSourcingHandler
    public void onMemberAccepted(MemberAcceptedEvent event) {
        appliedMembers.remove(event.getMemberId());
    }

    @EventSourcingHandler
    public void onMemberRejected(MemberRejectedEvent event) {
        appliedMembers.remove(event.getMemberId());
    }

    @EventSourcingHandler
    public void onCloseRecruitment(TeamRecruitmentClosedEvent event) {
        status = TeamRecruitmentStatus.CLOSED;
    }

    @EventSourcingHandler
    public void onFinishRecruitment(TeamRecruitmentFinishedEvent event) {
        status = TeamRecruitmentStatus.FINISHED;
    }

}
