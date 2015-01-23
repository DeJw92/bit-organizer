package pl.edu.knbit.domain.aggregateRoots.projectIdea.commands;

import pl.edu.knbit.domain.aggregateRoots.projectIdea.valueObjects.ProjectIdeaID;

/**
 * Created by eric on 1/1/15.
 */
public class CreateProjectIdeaCommand {

    private final ProjectIdeaID projectIdeaID;

    private final String description;

    public CreateProjectIdeaCommand(ProjectIdeaID projectIdeaID, String description) {
        this.projectIdeaID = projectIdeaID;
        this.description = description;
    }

    public ProjectIdeaID getProjectIdeaID() {
        return projectIdeaID;
    }

    public String getDescription() {
        return description;
    }

}
