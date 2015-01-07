package pl.edu.knbit.organizer.aggregate_roots.project_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class ProjectPlacedInStructureEvent extends AbstractProjectEvent {
    public ProjectPlacedInStructureEvent(ProjectID projectID) {
        super(projectID);
    }
}
