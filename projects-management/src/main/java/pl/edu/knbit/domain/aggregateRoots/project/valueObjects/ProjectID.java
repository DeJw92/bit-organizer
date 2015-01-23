package pl.edu.knbit.domain.aggregateRoots.project.valueObjects;

/**
 * @author Dawid Pawlak, Pawel Kolodziejczyk
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectID projectID = (ProjectID) o;

        return id.equals(projectID.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }
}
