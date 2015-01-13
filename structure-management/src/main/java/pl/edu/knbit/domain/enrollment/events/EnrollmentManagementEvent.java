package pl.edu.knbit.domain.enrollment.events;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;

public abstract class EnrollmentManagementEvent {

    @TargetAggregateIdentifier
    private final EnrollmentId enrollmentId;

    public EnrollmentManagementEvent(EnrollmentId enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }
}
