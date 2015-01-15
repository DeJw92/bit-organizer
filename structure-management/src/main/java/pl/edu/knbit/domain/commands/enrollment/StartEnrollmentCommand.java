package pl.edu.knbit.domain.commands.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class StartEnrollmentCommand extends EnrollmentManagementCommand {

    public StartEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
