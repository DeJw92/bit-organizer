package pl.edu.knbit.domain.events.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class EnrollmentCanceledEvent extends EnrollmentManagementEvent {

    public EnrollmentCanceledEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
