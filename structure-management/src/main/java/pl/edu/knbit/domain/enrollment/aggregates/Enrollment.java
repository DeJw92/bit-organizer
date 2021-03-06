package pl.edu.knbit.domain.enrollment.aggregates;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.domain.enrollment.events.*;
import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;
import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentStatus;
import pl.edu.knbit.domain.enrollment.valueObjects.MembershipRequestId;

import java.util.HashSet;
import java.util.Set;

public class Enrollment extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private EnrollmentId id;
    private String title;
    private String description;
    private EnrollmentStatus status;
    private EnrollmentConfiguration configuration;
    private Set<MembershipRequestId> membershipRequestIds;

    private Enrollment() {
    }

    Enrollment(EnrollmentId id, String title, String description, EnrollmentConfiguration configuration) {
        apply(new EnrollmentCreatedEvent(id, title, description, configuration));
    }

    public void addMembershipRequest(MembershipRequestId membershipRequestId) {
        if (status != EnrollmentStatus.STARTED) {
            apply(new EnrollmentIsNotStartedEvent(id, status));
            return;
        }

        if (membershipRequestIds.contains(membershipRequestId)) {
            apply(new EnrollmentAlreadyContainsMembershipRequestEvent(id, membershipRequestId));
            return;
        }

        if (!isRequestsCountLimitSatisfied()) {
            apply(new EnrollmentIsFullEvent(id));
            return;
        }

        apply(new MembershipRequestAddedEvent(id, membershipRequestId));
    }

    public void startEnrollment() {
        apply(new EnrollmentStartedEvent(id));
    }

    public void cancelEnrollment() {
        apply(new EnrollmentCanceledEvent(id));
    }

    public void endEnrollment() {
        apply(new EnrollmentEndedEvent(id));
    }

    @EventSourcingHandler
    public void onEnrollmentCreated(EnrollmentCreatedEvent event) {
        this.id = event.getEnrollmentId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.status = EnrollmentStatus.CREATED;
        this.configuration = event.getConfiguration();
        this.membershipRequestIds = new HashSet<>();
    }

    @EventSourcingHandler
    public void onEnrollmentStarted(EnrollmentStartedEvent enrollmentStartedEvent) {
        status = EnrollmentStatus.STARTED;
    }

    @EventSourcingHandler
    public void onEnrollmentCanceled(EnrollmentCanceledEvent enrollmentCanceledEvent) {
        status = EnrollmentStatus.CANCELED;
    }

    @EventSourcingHandler
    public void onEnrollmentEnded(EnrollmentEndedEvent enrollmentEndedEvent) {
        status = EnrollmentStatus.ENDED;
    }

    @EventSourcingHandler
    public void onMembershipRequestAdded(MembershipRequestAddedEvent membershipRequestAddedEvent) {
        membershipRequestIds.add(membershipRequestAddedEvent.getMembershipRequestId());
    }

    private boolean isRequestsCountLimitSatisfied() {
        return membershipRequestIds.size() < configuration.getRequestsLimit();
    }
}
