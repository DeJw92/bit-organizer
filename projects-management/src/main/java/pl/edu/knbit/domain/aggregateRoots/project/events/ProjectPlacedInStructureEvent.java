package pl.edu.knbit.domain.aggregateRoots.project.events;

import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class ProjectPlacedInStructureEvent extends AbstractProjectEvent {
    public ProjectPlacedInStructureEvent(ProjectID projectID) {
        super(projectID);
    }
}
