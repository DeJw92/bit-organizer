package ddd.domain.events;

import ddd.domain.value_objects.ProjectIdeaID;

/**
 * Created by eric on 1/1/15.
 */
public class TeamLeaderRecruitmentClosedEvent {

    private final ProjectIdeaID projectIdeaID;

    public TeamLeaderRecruitmentClosedEvent(ProjectIdeaID projectIdeaID){
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }


}
