package pl.edu.knbit.domain.enrollment.aggregates;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.domain.enrollment.aggregates.exceptions.EnrollmentAlreadyContainsThisMembershipRequest;
import pl.edu.knbit.domain.enrollment.aggregates.exceptions.EnrollmentCantChangeStatus;
import pl.edu.knbit.domain.enrollment.aggregates.exceptions.EnrollmentIsFull;
import pl.edu.knbit.domain.enrollment.aggregates.exceptions.EnrollmentIsNotStarted;
import pl.edu.knbit.domain.enrollment.events.*;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentStatus;
import pl.edu.knbit.domain.enrollment.valueobjects.MembershipRequestId;

import java.util.Collections;
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

    private Enrollment() {}

    Enrollment(EnrollmentId id, String title, String description, EnrollmentConfiguration configuration) {
        apply(new EnrollmentCreatedEvent(id, title, description, configuration));
    }

    public void addMembershipRequest(MembershipRequestId membershipRequestId) {
        if (status != EnrollmentStatus.STARTED)
            throw new EnrollmentIsNotStarted(status);

        if (membershipRequestIds.contains(membershipRequestId))
            throw new EnrollmentAlreadyContainsThisMembershipRequest(membershipRequestId);

        if (!isRequestsCountLimitSatisfied())
            throw new EnrollmentIsFull();

        apply(new MembershipRequestAddedEvent(id, membershipRequestId));
    }

    public void startEnrollment() {
        if (!status.canChangeStateTo(EnrollmentStatus.STARTED))
            throw new EnrollmentCantChangeStatus(status, EnrollmentStatus.STARTED);
        apply(new EnrollmentStartedEvent(id));
    }

    public void cancelEnrollment() {
        if (!status.canChangeStateTo(EnrollmentStatus.CANCELED))
            throw new EnrollmentCantChangeStatus(status, EnrollmentStatus.CANCELED);
        apply(new EnrollmentCanceledEvent(id));
    }

    public void endEnrollment() {
        if (!status.canChangeStateTo(EnrollmentStatus.ENDED))
            throw new EnrollmentCantChangeStatus(status, EnrollmentStatus.ENDED);
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public EnrollmentConfiguration getConfiguration() {
        return configuration;
    }

    public Set<MembershipRequestId> getMembershipRequestIds() {
        return Collections.unmodifiableSet(membershipRequestIds);
    }
}
