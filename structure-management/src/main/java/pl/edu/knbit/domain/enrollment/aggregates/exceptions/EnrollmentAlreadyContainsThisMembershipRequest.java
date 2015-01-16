package pl.edu.knbit.domain.enrollment.aggregates.exceptions;


import pl.edu.knbit.domain.enrollment.valueobjects.MembershipRequestId;

public class EnrollmentAlreadyContainsThisMembershipRequest extends IllegalStateException {

    public final MembershipRequestId membershipRequestId;

    public EnrollmentAlreadyContainsThisMembershipRequest(MembershipRequestId membershipRequestId) {
        this.membershipRequestId = membershipRequestId;
    }
}
