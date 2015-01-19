package pl.edu.knbit.domain.membershiprequest.events;

import pl.edu.knbit.domain.membershiprequest.valueobjects.MembershipRequestId;

/**
 * Created by mypood on 11/01/15.
 */
public class MembershipRequestAcceptedEvent {

    private final MembershipRequestId membershipRequestID;
    private final String memberID;


    public MembershipRequestAcceptedEvent(MembershipRequestId membershipRequestID, String memberID) {
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
