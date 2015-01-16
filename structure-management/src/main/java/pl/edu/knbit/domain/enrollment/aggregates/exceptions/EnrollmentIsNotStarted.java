package pl.edu.knbit.domain.enrollment.aggregates.exceptions;


import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentStatus;

public class EnrollmentIsNotStarted extends IllegalStateException {

    public final EnrollmentStatus actualStatus;

    public EnrollmentIsNotStarted(EnrollmentStatus actualStatus) {
        this.actualStatus = actualStatus;
    }
}
