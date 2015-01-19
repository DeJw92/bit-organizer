package pl.edu.knbit.domain.membershiprequest.valueobjects;

import java.util.UUID;

/**
 * Created by mypood on 15/01/15.
 */
public class MembershipRequestId {




    private final UUID id;

    public  static MembershipRequestId of (UUID id) {
        return new MembershipRequestId(id);
    }

    private MembershipRequestId(UUID id){
        this.id = id;
    }


    @Override
    public String toString() {
        return id.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembershipRequestId that = (MembershipRequestId) o;

       // if (!id.equals(that.id)) return false;

        if(id.compareTo(that.id) != 0) return false;

        return true;
    }





}
