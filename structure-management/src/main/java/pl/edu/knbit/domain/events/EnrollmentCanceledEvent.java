package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class EnrollmentCanceledEvent extends EnrollmentManagementEvent {

    public EnrollmentCanceledEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
