package pl.edu.knbit.domain.aggregateRoots.projectIdea.commands;


import pl.edu.knbit.domain.aggregateRoots.projectIdea.valueObjects.ProjectIdeaID;

/**
 * Created by eric on 12/31/14.
 */

public class SelectIdeaCommand {

    private final ProjectIdeaID projectIdeaID;

    public SelectIdeaCommand(ProjectIdeaID projectIdeaID) {
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID() {
        return projectIdeaID;
    }

}
