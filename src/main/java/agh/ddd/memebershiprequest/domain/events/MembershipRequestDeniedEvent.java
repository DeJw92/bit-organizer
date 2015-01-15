package agh.ddd.memebershiprequest.domain.events;

import agh.ddd.memebershiprequest.domain.valueobjects.MembershipRequestId;

/**
 * Created by mypood on 11/01/15.
 */
public class MembershipRequestDeniedEvent {



    private final String memberID;
    private final MembershipRequestId membershipRequestID;


    public MembershipRequestDeniedEvent(MembershipRequestId membershipRequestID, String memberID){
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
