package pl.edu.knbit.domain.events.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class EnrollmentStartedEvent extends EnrollmentManagementEvent {

    public EnrollmentStartedEvent(EnrollmentId enrollmentId) {
        super(enrollmentId);
    }
}
