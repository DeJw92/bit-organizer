package pl.edu.knbit.organizer.aggregateRoots.project.events;

import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

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
