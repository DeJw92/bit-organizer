package pl.edu.knbit.domain.enrollment.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;

abstract class EnrollmentManagementCommand {

    @TargetAggregateIdentifier
    private final EnrollmentId enrollmentId;

    public EnrollmentManagementCommand(EnrollmentId enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }
}
