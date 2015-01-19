package pl.edu.knbit.domain.membershiprequest.commands;

import pl.edu.knbit.domain.membershiprequest.valueobjects.MembershipRequestId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by mypood on 11/01/15.
 */
public class DenyMembershipRequestCommand {


    @TargetAggregateIdentifier
    private final MembershipRequestId membershipRequestID;
    private final String memberID;


    public DenyMembershipRequestCommand(MembershipRequestId membershipRequestID, String memberID) {
        this.membershipRequestID = membershipRequestID;
        this.memberID = memberID;
    }

    public MembershipRequestId getMembershipRequestID() {
        return membershipRequestID;
    }

    public String getMemberID() {
        return memberID;
    }
}
