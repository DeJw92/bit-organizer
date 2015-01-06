package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class EnrollmentCreatedEvent extends EnrollmentManagementEvent {

    private final String title;
    private final String description;
    private final EnrollmentConfiguration configuration;

    public EnrollmentCreatedEvent(EnrollmentId enrollmentId, String title, String description, EnrollmentConfiguration configuration) {
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
