package pl.edu.knbit.domain.enrollment.events;

import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;

public class EnrollmentStartedEvent extends EnrollmentManagementEvent {

    public EnrollmentStartedEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
