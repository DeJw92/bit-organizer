package ddd.domain.events;

import ddd.domain.value_objects.ProjectIdeaID;

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
