package pl.edu.knbit.organizer;

public class TeamRecruitmentId {

    private final long id;

    public TeamRecruitmentId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamRecruitmentId that = (TeamRecruitmentId) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }
}
