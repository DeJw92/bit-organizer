package pl.edu.knbit.domain.events.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentStatus;

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
