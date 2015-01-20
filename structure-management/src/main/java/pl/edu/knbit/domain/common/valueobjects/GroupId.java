package pl.edu.knbit.domain.common.valueobjects;

import java.util.UUID;

/**
 * Created by mwrona.
 */
public class GroupId {
    private final UUID id;

    public GroupId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupId groupId = (GroupId) o;

        if (!id.equals(groupId.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "GroupId{" +
                "id=" + id +
                '}';
    }
}
