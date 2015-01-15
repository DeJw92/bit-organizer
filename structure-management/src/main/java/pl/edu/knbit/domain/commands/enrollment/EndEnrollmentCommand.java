package pl.edu.knbit.domain.commands.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class EndEnrollmentCommand extends EnrollmentManagementCommand {

    public EndEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
