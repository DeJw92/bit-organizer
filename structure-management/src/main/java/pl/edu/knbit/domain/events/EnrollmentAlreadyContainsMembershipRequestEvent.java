package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.MembershipRequestId;

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
