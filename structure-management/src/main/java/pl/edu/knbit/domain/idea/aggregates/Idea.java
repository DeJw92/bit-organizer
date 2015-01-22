package pl.edu.knbit.domain.idea.aggregates;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.idea.events.*;
import pl.edu.knbit.domain.idea.exceptions.ParentGroupNotSelectedException;
import pl.edu.knbit.domain.idea.valueobjects.IdeaId;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.domain.member.valueobjects.MemberId;

public class Idea extends AbstractAnnotatedAggregateRoot {
    private static enum Status { SUBMITTED, ACCEPTED, INACTIVE }

    @AggregateIdentifier
    private IdeaId id;
    private String title;
    private String description;
    private GroupId parentGroupId;
    private Status status;
    private MemberId groupSupervisorId;
    private EnrollmentId enrollmentId;

    private Idea() {
    }

    public Idea(IdeaId id, String title, String description) {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(StringUtils.trimToNull(title));
        apply(new IdeaSubmittedEvent(id, title, description));
    }

    public GroupId getParentGroupId() {
        return parentGroupId;
    }

    public void selectParentGroup(GroupId groupId) {
        Preconditions.checkNotNull(groupId);
        Preconditions.checkState(this.status == Status.SUBMITTED || this.status == Status.ACCEPTED);
        apply(new ParentGroupSelectedEvent(this.id, groupId));
    }

    public void selectGroupSupervisor(MemberId groupSupervisorId) throws ParentGroupNotSelectedException {
        Preconditions.checkNotNull(groupSupervisorId);
        Preconditions.checkState(this.status == Status.SUBMITTED || this.status == Status.ACCEPTED);
        apply(new GroupSupervisorSelectedEvent(this.id, this.parentGroupId, groupSupervisorId));
    }

    public void accept() throws IllegalStateException {
        Preconditions.checkState(this.status == Status.SUBMITTED, String.format("Cannot accept idea in state %s", this.status));
        apply(new IdeaAcceptedEvent(this.id));
    }

    public void reject() {
        Preconditions.checkState(this.status == Status.SUBMITTED, String.format("Cannot reject idea in state %s", this.status));
        apply(new IdeaRejectedEvent(this.id));
    }

    public void abandon() {
        Preconditions.checkState(this.status == Status.ACCEPTED, String.format("Cannot abandon idea in state %s", this.status));
        apply(new IdeaAbandonedEvent(this.id));
    }

    public void setEnrollmentId(EnrollmentId enrollmentId) {
        Preconditions.checkState(this.status == Status.ACCEPTED, String.format("Cannot create enrollment for idea in state %s", this.status));
        apply(new EnrollmentCreatedEvent(this.id, enrollmentId));
    }

    @EventSourcingHandler
    public void onIdeaSubmitted(IdeaSubmittedEvent ideaSubmittedEvent) {
        this.id = ideaSubmittedEvent.getIdeaId();
        this.title = ideaSubmittedEvent.getTitle();
        this.description = ideaSubmittedEvent.getDescription();
        this.status = Status.SUBMITTED;
    }

    @EventSourcingHandler
    public void onParentGroupSelected(ParentGroupSelectedEvent parentGroupSelectedEvent) {
        this.parentGroupId = parentGroupSelectedEvent.getParentGroupId();
    }
    @EventSourcingHandler
    public void onGroupSupervisorSelected(GroupSupervisorSelectedEvent groupSupervisorSelectedEvent) {
        this.groupSupervisorId = groupSupervisorSelectedEvent.getGroupSupervisorId();
    }

    @EventSourcingHandler
     public void onIdeaAccepted(IdeaAcceptedEvent ideaAcceptedEvent) {
        this.status = Status.ACCEPTED;
    }

    @EventSourcingHandler
    public void onIdeaRejected(IdeaRejectedEvent ideaRejectedEvent) {
        this.status = Status.INACTIVE;
    }

    @EventSourcingHandler
    public void onEnrollmentCreated(EnrollmentCreatedEvent enrollmentCreatedEvent) {
        this.enrollmentId = enrollmentCreatedEvent.getEnrollmentId();
    }
}
