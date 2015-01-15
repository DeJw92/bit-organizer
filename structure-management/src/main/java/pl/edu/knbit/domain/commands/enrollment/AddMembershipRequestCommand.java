package pl.edu.knbit.domain.commands.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.MembershipRequestId;

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
