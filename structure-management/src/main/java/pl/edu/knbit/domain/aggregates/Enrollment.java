package pl.edu.knbit.domain.aggregates;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.domain.events.*;
import pl.edu.knbit.domain.valueobjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.EnrollmentStatus;

import java.util.HashSet;
import java.util.Set;

public class Enrollment extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private EnrollmentId id;
    private String title;
    private String description;
    private EnrollmentStatus status;
    private EnrollmentConfiguration configuration;
    private Set<MembershipRequest> membershipRequests;

    private Enrollment() {}

    Enrollment(EnrollmentId id, String title, String description, EnrollmentConfiguration configuration) {
        apply(new EnrollmentCreatedEvent(id, title, description, configuration));
    }

    public void addMembershipRequest(MembershipRequest membershipRequest) {
        if (status != EnrollmentStatus.OPENED) {
            apply(new EnrollmentIsNotOpenedEvent(id, status));
            return;
        }

        if (!isRequestsCountLimitSatisfied()) {
            apply(new EnrollmentIsFullEvent(id));
            return;
        }

        apply(new MembershipRequestAddedEvent(id, membershipRequest));
    }

    public void cancelEnrollment() {
        apply(new EnrollmentCanceledEvent(id));
    }

    public void closeEnrollment() {
        apply(new EnrollmentClosedEvent(id));
    }

    @EventSourcingHandler
    public void onEnrollmentCreated(EnrollmentCreatedEvent event) {
        this.id = event.getEnrollmentId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.status = EnrollmentStatus.OPENED;
        this.configuration = event.getConfiguration();
        this.membershipRequests = new HashSet<>();
    }

    @EventSourcingHandler
    public void onEnrollmentCanceled(EnrollmentCanceledEvent enrollmentCanceledEvent) {
        status = EnrollmentStatus.CANCELED;
    }

    @EventSourcingHandler
    public void onEnrollmentClosed(EnrollmentClosedEvent enrollmentClosedEvent) {
        status = EnrollmentStatus.CLOSED;
    }

    @EventSourcingHandler
    public void onMembershipRequestAdded(MembershipRequestAddedEvent membershipRequestAddedEvent) {
        membershipRequests.add(membershipRequestAddedEvent.getMembershipRequest());
    }

    private boolean isRequestsCountLimitSatisfied() {
        return membershipRequests.size() < configuration.getRequestsLimit();
    }
}
