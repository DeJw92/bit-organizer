package pl.edu.knbit.domain.aggregateRoots.project.commands;

import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class PlaceProjectInStructureCommand extends AbstractProjectCommand {
    public PlaceProjectInStructureCommand(ProjectID projectID) {
        super(projectID);
    }
}
