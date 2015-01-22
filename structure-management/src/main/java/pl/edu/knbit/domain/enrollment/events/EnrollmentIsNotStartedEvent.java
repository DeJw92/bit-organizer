package pl.edu.knbit.domain.enrollment.events;

import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;
import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentStatus;

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
