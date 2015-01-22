package pl.edu.knbit.domain.enrollment.events;

import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;

public class EnrollmentIsFullEvent extends EnrollmentManagementEvent {

    public EnrollmentIsFullEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
