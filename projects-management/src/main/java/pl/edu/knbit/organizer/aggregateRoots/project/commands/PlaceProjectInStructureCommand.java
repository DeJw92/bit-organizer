package pl.edu.knbit.organizer.aggregateRoots.project.commands;

import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class PlaceProjectInStructureCommand extends AbstractProjectCommand {
    public PlaceProjectInStructureCommand(ProjectID projectID) {
        super(projectID);
    }
}
