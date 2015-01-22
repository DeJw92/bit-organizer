package pl.edu.knbit.domain.enrollment.events;

import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;

public class EnrollmentCanceledEvent extends EnrollmentManagementEvent {

    public EnrollmentCanceledEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
