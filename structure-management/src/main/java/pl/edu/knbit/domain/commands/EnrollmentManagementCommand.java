package pl.edu.knbit.domain.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.valueobjects.EnrollmentId;

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
