package pl.edu.knbit.domain.enrollment.commands;

import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;

public class CreateEnrollmentCommand extends EnrollmentManagementCommand {

    private final String title;
    private final String description;
    private final EnrollmentConfiguration configuration;

    public CreateEnrollmentCommand(EnrollmentId enrollmentId, String title, String description, EnrollmentConfiguration configuration) {
        super(enrollmentId);
        this.title = title;
        this.description = description;
        this.configuration = configuration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public EnrollmentConfiguration getConfiguration() {
        return configuration;
    }
}
