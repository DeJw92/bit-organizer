package pl.edu.knbit.domain.member.valueobjects;

import java.util.UUID;

/**
 * Created by mwrona.
 */
public class MemberId {
    private final UUID id;

    public MemberId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberId memberId = (MemberId) o;

        if (!id.equals(memberId.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "MemberId{" +
                "id=" + id +
                '}';
    }
}
