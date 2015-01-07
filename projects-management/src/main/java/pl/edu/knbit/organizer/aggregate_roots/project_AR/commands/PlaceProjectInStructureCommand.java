package pl.edu.knbit.organizer.aggregate_roots.project_AR.commands;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class PlaceProjectInStructureCommand extends AbstractProjectCommand {
    public PlaceProjectInStructureCommand(ProjectID projectID) {
        super(projectID);
    }
}
