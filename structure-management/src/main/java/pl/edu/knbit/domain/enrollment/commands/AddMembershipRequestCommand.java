package pl.edu.knbit.domain.enrollment.commands;

import pl.edu.knbit.domain.enrollment.valueObjects.EnrollmentId;
import pl.edu.knbit.domain.enrollment.valueObjects.MembershipRequestId;

public class AddMembershipRequestCommand extends EnrollmentManagementCommand {

    private final MembershipRequestId membershipRequestId;

    public AddMembershipRequestCommand(EnrollmentId enrollmentId, MembershipRequestId membershipRequestId) {
        super(enrollmentId);
        this.membershipRequestId = membershipRequestId;
    }

    public MembershipRequestId getMembershipRequestId() {
        return membershipRequestId;
    }
}
