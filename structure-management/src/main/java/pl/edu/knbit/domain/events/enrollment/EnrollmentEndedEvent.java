package pl.edu.knbit.domain.events.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class EnrollmentEndedEvent extends EnrollmentManagementEvent {

    public EnrollmentEndedEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
