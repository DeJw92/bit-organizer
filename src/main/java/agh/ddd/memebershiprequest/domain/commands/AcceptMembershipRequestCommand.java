package agh.ddd.memebershiprequest.domain.commands;


import agh.ddd.memebershiprequest.domain.valueobjects.MembershipRequestId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;


/**
 * Created by mypood on 11/01/15.
 */
public class AcceptMembershipRequestCommand {

    @TargetAggregateIdentifier
    private final MembershipRequestId membershipRequestID;
    private final String memberID;

    public AcceptMembershipRequestCommand(MembershipRequestId membershipRequestID, String memberID) {
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