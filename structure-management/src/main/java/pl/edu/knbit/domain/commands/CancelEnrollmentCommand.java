package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class CancelEnrollmentCommand extends EnrollmentManagementCommand {

    public CancelEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
