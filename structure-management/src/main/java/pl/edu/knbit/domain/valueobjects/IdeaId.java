package pl.edu.knbit.domain.valueobjects;

import java.util.UUID;

public class IdeaId {
    private final UUID id;

    private IdeaId(UUID uuid) {
        this.id = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdeaId ideaId = (IdeaId) o;

        if (!id.equals(ideaId.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "IdeaId{" +
                "id=" + id +
                '}';
    }

    public static IdeaId nextId() {
        return new IdeaId(UUID.randomUUID());
    }
}
