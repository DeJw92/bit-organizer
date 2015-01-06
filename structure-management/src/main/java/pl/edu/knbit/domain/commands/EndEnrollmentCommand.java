package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class EndEnrollmentCommand extends EnrollmentManagementCommand {

    public EndEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
