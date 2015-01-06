package pl.edu.knbit.organizer.teamleader_recruitment.value_objects;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class MemberId {

    private final long id;

    public MemberId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberId memberId = (MemberId) o;

        if (id != memberId.id) return false;

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
