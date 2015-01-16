package pl.edu.knbit.domain.enrollment.aggregates.exceptions;


import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentStatus;

public class EnrollmentCantChangeStatus extends IllegalStateException {

    public final EnrollmentStatus actualStatus;
    public final EnrollmentStatus targetStatus;

    public EnrollmentCantChangeStatus(EnrollmentStatus actualStatus, EnrollmentStatus targetStatus) {
        this.actualStatus = actualStatus;
        this.targetStatus = targetStatus;
    }
}
