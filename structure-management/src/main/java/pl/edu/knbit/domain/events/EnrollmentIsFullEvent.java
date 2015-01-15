package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class EnrollmentIsFullEvent extends EnrollmentManagementEvent {

    public EnrollmentIsFullEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
