package pl.edu.knbit.organizer.aggregate_roots.project_idea.commands;

import pl.edu.knbit.organizer.aggregate_roots.project_idea.value_objects.ProjectIdeaID;

import java.lang.String;

/**
 * Created by eric on 1/1/15.
 */
public class CreateProjectIdeaCommand {

    private final ProjectIdeaID projectIdeaID;

    private final String description;

    public CreateProjectIdeaCommand(ProjectIdeaID projectIdeaID, String description){
        this.projectIdeaID = projectIdeaID;
        this.description = description;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }

    public String getDescription() { return description; }

}
