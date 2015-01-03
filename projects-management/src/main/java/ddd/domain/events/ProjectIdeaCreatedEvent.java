package ddd.domain.events;

import ddd.domain.entities.TeamLeaderRecruitment;
import ddd.domain.value_objects.ProjectIdeaID;

/**
 * Created by eric on 1/1/15.
 */
public class ProjectIdeaCreatedEvent {

    private final ProjectIdeaID projectIdeaID;
    private final TeamLeaderRecruitment teamLeaderRecruitment;

    public ProjectIdeaCreatedEvent(ProjectIdeaID projectIdeaID, TeamLeaderRecruitment teamLeaderRecruitment){
        this.teamLeaderRecruitment = teamLeaderRecruitment;
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }

    public TeamLeaderRecruitment getTeamLeaderRecruitment(){
        return teamLeaderRecruitment;
    }

}
