package pl.edu.knbit.domain.enrollment.commands;

import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;

public class EndEnrollmentCommand extends EnrollmentManagementCommand {

    public EndEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
