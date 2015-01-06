package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class StartEnrollmentCommand extends EnrollmentManagementCommand {

    public StartEnrollmentCommand(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
