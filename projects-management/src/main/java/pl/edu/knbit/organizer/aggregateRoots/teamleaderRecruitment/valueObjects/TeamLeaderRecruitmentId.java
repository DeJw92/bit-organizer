package pl.edu.knbit.organizer.aggregateRoots.teamleaderRecruitment.valueObjects;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class TeamLeaderRecruitmentId {

    private final long id;

    public TeamLeaderRecruitmentId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamLeaderRecruitmentId that = (TeamLeaderRecruitmentId) o;

        if (id != that.id) return false;

        return true;
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
