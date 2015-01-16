package pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.events;



import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.value_objects.ProjectIdeaID;

/**
 * Created by eric
 */

public class ProjectIdeaCreatedEvent {

    private final ProjectIdeaID projectIdeaID;
    private final String description;

    public ProjectIdeaCreatedEvent(ProjectIdeaID projectIdeaID , String description){
        this.projectIdeaID = projectIdeaID;
        this.description = description;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }

    public String getDescription() { return description; }

}
