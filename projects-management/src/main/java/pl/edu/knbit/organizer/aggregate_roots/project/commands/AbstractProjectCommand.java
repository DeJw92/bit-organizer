package pl.edu.knbit.organizer.aggregate_roots.project.commands;

import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

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
