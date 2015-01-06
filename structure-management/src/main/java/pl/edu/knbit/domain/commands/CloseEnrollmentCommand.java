package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class CloseEnrollmentCommand extends EnrollmentManagementCommand {

    public CloseEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
