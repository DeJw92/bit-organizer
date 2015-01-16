package pl.edu.knbit.domain.enrollment.events;

import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;

public class EnrollmentEndedEvent extends EnrollmentManagementEvent {

    public EnrollmentEndedEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
