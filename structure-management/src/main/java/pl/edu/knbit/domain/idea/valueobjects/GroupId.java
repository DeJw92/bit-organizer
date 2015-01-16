package pl.edu.knbit.domain.idea.valueobjects;

public class GroupId {
    private final String id;

    public GroupId(String id) {
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
                "id='" + id + '\'' +
                '}';
    }
}
