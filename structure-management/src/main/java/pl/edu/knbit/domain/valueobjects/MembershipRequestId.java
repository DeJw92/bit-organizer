package pl.edu.knbit.domain.valueobjects;

import java.util.UUID;

public class MembershipRequestId {
    private final UUID id;

    public MembershipRequestId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembershipRequestId membershipRequestId = (MembershipRequestId) o;

        return id.equals(membershipRequestId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("MembershipRequestId(id=%s)", id);
    }
}
