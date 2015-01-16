package pl.edu.knbit.domain.idea.valueobjects;

import java.util.UUID;

public class MemberId {
    private final UUID id;

    public MemberId(UUID uuid) {
        this.id = uuid;
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

    public static MemberId nextId() {
        return new MemberId(UUID.randomUUID());
    }
}
