package pl.edu.knbit.domain.aggregates.idea;

import pl.edu.knbit.domain.events.idea.*;
import pl.edu.knbit.domain.exceptions.ParentGroupNotSelectedException;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.domain.valueobjects.UserId;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class Idea extends AbstractAnnotatedAggregateRoot {
    private static enum Status { SUBMITTED, ACCEPTED, INACTIVE }

    @AggregateIdentifier
    private IdeaId id;
    private String title;
    private String description;
    private GroupId parentGroupId;
    private Status status;
    private UserId groupSupervisorId;
    private EnrollmentId enrollmentId;

    private Idea() {
    }

    public Idea(IdeaId id, String title, String description) {
        apply(new IdeaSubmittedEvent(id, title, description));
    }

    public GroupId getParentGroupId() {
        return parentGroupId;
    }

    public void selectParentGroup(GroupId groupId) {
        apply(new ParentGroupSelectedEvent(this.id, groupId));
    }

    public void accept() throws IllegalStateException {
        if(this.status != Status.SUBMITTED){
//            IllegalStateException or rename IdeaAlreadyAcceptedException
            throw new IllegalStateException(String.format("Cannot accept idea in state %s", this.status));
        }
        apply(new IdeaAcceptedEvent(this.id));
    }

    public void selectGroupSupervisor(UserId groupSupervisorId) throws ParentGroupNotSelectedException {
        apply(new GroupSupervisorSelectedEvent(this.id, this.parentGroupId, groupSupervisorId));
    }

    public void reject() {
//            IllegalStateException or create custom exception
        if(this.status != Status.SUBMITTED){
            throw new IllegalStateException(String.format("Cannot reject idea in state %s", this.status));
        }
        apply(new IdeaRejectedEvent(this.id));
    }

    public void abandon() {
        if(this.status != Status.ACCEPTED){
//            IllegalStateException or create custom exception
            throw new IllegalStateException(String.format("Cannot abandon idea in state %s", this.status));
        }
        apply(new IdeaAbandonedEvent(this.id));
    }
    public void setEnrollment(EnrollmentId enrollmentId) {
        if(this.status != Status.ACCEPTED) {
            throw new IllegalStateException(String.format("Cannot create enrollment for idea in state %s", this.status));
        }
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
