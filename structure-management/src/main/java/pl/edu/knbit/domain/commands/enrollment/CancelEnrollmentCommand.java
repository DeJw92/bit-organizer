package pl.edu.knbit.domain.commands.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class CancelEnrollmentCommand extends EnrollmentManagementCommand {

    public CancelEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}