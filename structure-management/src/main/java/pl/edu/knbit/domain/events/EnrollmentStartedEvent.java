package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class EnrollmentStartedEvent extends EnrollmentManagementEvent {

    public EnrollmentStartedEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
