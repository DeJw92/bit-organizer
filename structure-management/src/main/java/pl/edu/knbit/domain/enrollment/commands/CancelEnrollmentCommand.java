package pl.edu.knbit.domain.enrollment.commands;

import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;

public class CancelEnrollmentCommand extends EnrollmentManagementCommand {

    public CancelEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
