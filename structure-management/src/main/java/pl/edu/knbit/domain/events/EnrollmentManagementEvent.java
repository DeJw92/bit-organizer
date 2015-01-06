package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public abstract class EnrollmentManagementEvent {

    private final EnrollmentId enrollmentId;

    public EnrollmentManagementEvent(EnrollmentId enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }
}
