package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.aggregates.MembershipRequest;
import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class MembershipRequestAddedEvent extends EnrollmentManagementEvent {

    private final MembershipRequest membershipRequest;

    public MembershipRequestAddedEvent(EnrollmentId enrollmentId, MembershipRequest membershipRequest) {
        super(enrollmentId);
        this.membershipRequest = membershipRequest;
    }

    public MembershipRequest getMembershipRequest() {
        return membershipRequest;
    }
}
