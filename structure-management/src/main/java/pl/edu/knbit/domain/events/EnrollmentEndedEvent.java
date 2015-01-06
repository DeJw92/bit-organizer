package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class EnrollmentEndedEvent extends EnrollmentManagementEvent {

    public EnrollmentEndedEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
