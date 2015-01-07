package pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects;

import java.util.Objects;

/**
 * Created by Dawid Pawlak.
 */
public class ProjectID {

    private final String id;

    private ProjectID(String id) {
        this.id = id;
    }

    public static ProjectID of(String id) {
        return new ProjectID(id);
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
