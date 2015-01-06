package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class EnrollmentClosedEvent extends EnrollmentManagementEvent {

    public EnrollmentClosedEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
