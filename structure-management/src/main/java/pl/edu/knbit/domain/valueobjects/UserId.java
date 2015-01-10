package pl.edu.knbit.domain.valueobjects;

import java.util.UUID;

public class UserId {
    private final UUID id;

    public UserId(UUID uuid) {
        this.id = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserId userId = (UserId) o;

        if (!id.equals(userId.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public static UserId nextId() {
        return new UserId(UUID.randomUUID());
    }
}
