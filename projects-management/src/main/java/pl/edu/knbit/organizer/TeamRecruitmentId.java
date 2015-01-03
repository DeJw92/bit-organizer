package pl.edu.knbit.organizer;

import java.util.Objects;
import java.util.UUID;

public class TeamRecruitmentId {

    private final String id;

    public TeamRecruitmentId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamRecruitmentId that = (TeamRecruitmentId) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public static TeamRecruitmentId randomId() {
        final String uuid = UUID.randomUUID().toString();
        return new TeamRecruitmentId(uuid);
    }
}
