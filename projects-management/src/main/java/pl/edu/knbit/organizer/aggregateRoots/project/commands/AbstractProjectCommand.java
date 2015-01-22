package pl.edu.knbit.organizer.aggregateRoots.project.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class AbstractProjectCommand {

    @TargetAggregateIdentifier
    private ProjectID projectID;

    public AbstractProjectCommand(ProjectID projectID) {
        this.projectID = projectID;
    }

    public ProjectID getProjectID() {
        return projectID;
    }
}
