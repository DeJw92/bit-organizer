package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.aggregates.MembershipRequest;
import pl.edu.knbit.domain.valueobjects.EnrollmentId;

public class AddMembershipRequestCommand extends EnrollmentManagementCommand {

    private final MembershipRequest membershipRequest;

    public AddMembershipRequestCommand(EnrollmentId enrollmentId, MembershipRequest membershipRequest) {
        super(enrollmentId);
        this.membershipRequest = membershipRequest;
    }

    public MembershipRequest getMembershipRequest() {
        return membershipRequest;
    }
}
