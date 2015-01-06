package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.EnrollmentStatus;

public class EnrollmentIsNotStartedEvent extends EnrollmentManagementEvent {

    private EnrollmentStatus status;

    public EnrollmentIsNotStartedEvent(EnrollmentId enrollmentId, EnrollmentStatus status) {
        super(enrollmentId);
        this.status = status;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }
}
