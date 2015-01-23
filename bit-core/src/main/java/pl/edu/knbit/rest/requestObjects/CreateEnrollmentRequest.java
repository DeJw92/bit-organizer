package pl.edu.knbit.rest.requestObjects;

import pl.edu.knbit.domain.enrollment.commands.CreateEnrollmentCommand;
import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;

import java.util.UUID;

/**
 * @author mciolek
 */
public class CreateEnrollmentRequest {
    private String title;
    private String description;
    private Integer requestsLimit;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRequestsLimit() {
        return requestsLimit;
    }

    public CreateEnrollmentCommand asCommand() {
        EnrollmentId enrollmentId = new EnrollmentId(UUID.randomUUID());
        EnrollmentConfiguration configuration = new EnrollmentConfiguration(requestsLimit);
        return new CreateEnrollmentCommand(enrollmentId, title, description, configuration);
    }
}
