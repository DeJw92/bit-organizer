package pl.edu.knbit.domain.events.idea;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class EnrollmentCreatedEvent {
    @TargetAggregateIdentifier
    private final IdeaId ideaId;
    private final EnrollmentId enrollmentId;

    public IdeaId getIdeaId() {
        return ideaId;
    }

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }

    public EnrollmentCreatedEvent(IdeaId ideaId, EnrollmentId enrollmentId) {
        this.ideaId = ideaId;
        this.enrollmentId = enrollmentId;

    }
}
