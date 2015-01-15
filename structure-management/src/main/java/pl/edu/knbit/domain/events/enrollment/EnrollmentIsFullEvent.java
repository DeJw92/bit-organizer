package pl.edu.knbit.domain.events.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class EnrollmentIsFullEvent extends EnrollmentManagementEvent {

    public EnrollmentIsFullEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
