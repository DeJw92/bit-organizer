package pl.edu.knbit.domain.commands.idea;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.aggregates.enrollment.Enrollment;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentConfiguration;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class CreateEnrollmentCommand {
    @TargetAggregateIdentifier
    private final IdeaId ideaId;
    private final EnrollmentId enrollmentId;
    private final String title;
    private final String description;
    private final EnrollmentConfiguration enrollmentConfiguration;

    public CreateEnrollmentCommand(IdeaId ideaId, EnrollmentId enrollmentId, String title, String description, EnrollmentConfiguration enrollmentConfiguration) {
        this.ideaId = ideaId;
        this.enrollmentId = enrollmentId;
        this.title = title;
        this.description = description;

        this.enrollmentConfiguration = enrollmentConfiguration;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public EnrollmentConfiguration getEnrollmentConfiguration() {
        return enrollmentConfiguration;
    }
}
