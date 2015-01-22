package pl.edu.knbit.domain.idea.events;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class EnrollmentCreatedEvent {
    @TargetAggregateIdentifier
    private final IdeaId ideaId;
    private final EnrollmentId enrollmentId;

    public EnrollmentCreatedEvent(IdeaId ideaId, EnrollmentId enrollmentId) {
        this.ideaId = ideaId;
        this.enrollmentId = enrollmentId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }
}
