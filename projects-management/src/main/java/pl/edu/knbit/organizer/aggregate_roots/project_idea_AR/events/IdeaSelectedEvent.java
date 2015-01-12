package pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.value_objects.ProjectIdeaID;

/**
 * Created by eric on 12/31/14.
 */
public class IdeaSelectedEvent {

    private final ProjectIdeaID projectIdeaID;

    public IdeaSelectedEvent(ProjectIdeaID projectIdeaID){
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }

}
