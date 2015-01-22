package pl.edu.knbit.domain.enrollment.events;

import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;
import pl.edu.knbit.domain.enrollment.valueObjects.MembershipRequestId;

public class EnrollmentAlreadyContainsMembershipRequestEvent extends EnrollmentManagementEvent {

    private final MembershipRequestId membershipRequestId;

    public EnrollmentAlreadyContainsMembershipRequestEvent(EnrollmentId enrollmentId, MembershipRequestId membershipRequestId) {
        super(enrollmentId);
        this.membershipRequestId = membershipRequestId;
    }

    public MembershipRequestId getMembershipRequestId() {
        return membershipRequestId;
    }
}
