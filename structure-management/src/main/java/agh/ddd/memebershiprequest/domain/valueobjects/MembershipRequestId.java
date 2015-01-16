package agh.ddd.memebershiprequest.domain.valueobjects;

import agh.ddd.memebershiprequest.domain.MembershipRequest;

/**
 * Created by mypood on 15/01/15.
 */
public class MembershipRequestId {




    private final String id; //final, zeby bylo immutable

    public  static MembershipRequestId of (String id) {
        return new MembershipRequestId(id);
    }

    private MembershipRequestId(String id){
        this.id = id;
    }


    @Override
    public String toString() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembershipRequestId that = (MembershipRequestId) o;

        if (!id.equals(that.id)) return false;

        return true;
    }





}
