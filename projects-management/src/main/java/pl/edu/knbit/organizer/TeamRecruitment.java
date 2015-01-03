package pl.edu.knbit.organizer;

import com.google.common.base.Preconditions;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import pl.edu.knbit.organizer.events.*;

import java.util.ArrayList;
import java.util.List;

public class TeamRecruitment extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private TeamRecruitmentId id;
    private List<MemberId> appliedMembers = new ArrayList<>();
    private TeamRecruitmentStatus status;

    private TeamRecruitment() {
    }

    public TeamRecruitment(TeamRecruitmentId id, List<MemberId> appliedMembers, TeamRecruitmentStatus status) {
        // TODO Apply event instead?
        this.id = id;
        this.appliedMembers = appliedMembers;
        this.status = status;
    }

    public void appointMeeting(MemberId memberId) {
        Preconditions.checkState(status != TeamRecruitmentStatus.FINISHED);

        apply(new MeetingAppointedEvent(id, memberId));
    }

    public void applyForProject(MemberId memberId) {
        Preconditions.checkState(status == TeamRecruitmentStatus.OPEN);

        appliedMembers.add(memberId);
        apply(new MemberAppliedEvent(id, memberId));
    }

    public void acceptMember(MemberId memberId) {
        Preconditions.checkNotNull(memberId);
        Preconditions.checkArgument(appliedMembers.contains(memberId));
        Preconditions.checkState(status != TeamRecruitmentStatus.FINISHED);

        appliedMembers.remove(memberId);
        apply(new MemberAcceptedEvent(id, memberId));
    }

    public void rejectMember(MemberId memberId) {
        Preconditions.checkNotNull(memberId);
        Preconditions.checkArgument(appliedMembers.contains(memberId));
        Preconditions.checkState(status != TeamRecruitmentStatus.FINISHED);

        appliedMembers.remove(memberId);
        apply(new MemberRejectedEvent(id, memberId));
    }

    public void closeRecruitment() {
        Preconditions.checkState(status == TeamRecruitmentStatus.OPEN);

        status = TeamRecruitmentStatus.CLOSED;
        // TODO Do we want to send this event?
        apply(new TeamRecruitmentClosedEvent(id));
    }

    public void finishRecruitment() {
        // TODO Can we finish recruitment that wasn't closed?
        Preconditions.checkState(status != TeamRecruitmentStatus.FINISHED);

        status = TeamRecruitmentStatus.FINISHED;
        apply(new TeamRecruitmentFinishedEvent(id));
    }
}
