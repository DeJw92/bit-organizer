package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.EnrollmentStatus;

public class EnrollmentIsNotOpenedEvent extends EnrollmentManagementEvent {

    private EnrollmentStatus status;

    public EnrollmentIsNotOpenedEvent(EnrollmentId enrollmentId, EnrollmentStatus status) {
        super(enrollmentId);
        this.status = status;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }
}
