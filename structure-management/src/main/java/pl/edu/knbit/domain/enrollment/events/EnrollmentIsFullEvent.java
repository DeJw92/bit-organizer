package pl.edu.knbit.domain.enrollment.events;

import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;

public class EnrollmentIsFullEvent extends EnrollmentManagementEvent {

    public EnrollmentIsFullEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
