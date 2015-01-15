package pl.edu.knbit.domain.events.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.MembershipRequestId;

public class MembershipRequestAddedEvent extends EnrollmentManagementEvent {

    private final MembershipRequestId membershipRequestId;

    public MembershipRequestAddedEvent(EnrollmentId enrollmentId, MembershipRequestId membershipRequestId) {
        super(enrollmentId);
        this.membershipRequestId = membershipRequestId;
    }

    public MembershipRequestId getMembershipRequestId() {
        return membershipRequestId;
    }
}
