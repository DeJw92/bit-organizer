package ddd.domain.commands;

import ddd.domain.value_objects.ProjectIdeaID;

/**
 * Created by eric on 12/31/14.
 */

public class SelectIdeaCommand {

    private final ProjectIdeaID projectIdeaID;

    public SelectIdeaCommand(ProjectIdeaID projectIdeaID){
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }

}
