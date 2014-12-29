package ddd.domain.events;

import ddd.domain.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class AbstractProjectEvent {
    private ProjectID projectID;

    public AbstractProjectEvent(ProjectID projectID) {
        this.projectID = projectID;
    }

    public ProjectID getProjectID() {
        return projectID;
    }
}
