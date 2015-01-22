package pl.edu.knbit.domain.enrollment.commands;

import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;

public class StartEnrollmentCommand extends EnrollmentManagementCommand {

    public StartEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
