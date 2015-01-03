package ddd.domain.value_objects;

import java.util.Objects;

/**
 * Created by eric
 */
public class ProjectIdeaID {

    private final String id;

    private ProjectIdeaID(String id) {
        this.id = id;
    }

    public static ProjectIdeaID of(String id) {
        return new ProjectIdeaID(id);
    }

    @Override
    public boolean equals(Object object) {
        return Objects.equals(this, object);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
