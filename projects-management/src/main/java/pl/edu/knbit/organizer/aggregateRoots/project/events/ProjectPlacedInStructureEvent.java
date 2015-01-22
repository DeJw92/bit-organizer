package pl.edu.knbit.organizer.aggregateRoots.project.events;

import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class ProjectPlacedInStructureEvent extends AbstractProjectEvent {
    public ProjectPlacedInStructureEvent(ProjectID projectID) {
        super(projectID);
    }
}
