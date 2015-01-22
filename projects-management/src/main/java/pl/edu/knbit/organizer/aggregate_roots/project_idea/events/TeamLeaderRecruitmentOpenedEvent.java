package pl.edu.knbit.organizer.aggregate_roots.project_idea.events;


import pl.edu.knbit.organizer.aggregate_roots.project_idea.value_objects.ProjectIdeaID;

/**
 * Created by eric on 12/31/14.
 */
public class TeamLeaderRecruitmentOpenedEvent {

    private final ProjectIdeaID projectIdeaID;

    public TeamLeaderRecruitmentOpenedEvent(ProjectIdeaID projectIdeaID){
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }

}
