package ddd.domain.events;

import ddd.domain.entities.TeamLeaderRecruitment;
import ddd.domain.value_objects.ProjectIdeaID;

/**
 * Created by eric on 1/1/15.
 */
public class ProjectIdeaCreatedEvent {

    private final ProjectIdeaID projectIdeaID;
    private final TeamLeaderRecruitment teamLeaderRecruitment;
    private final String description;

    public ProjectIdeaCreatedEvent(ProjectIdeaID projectIdeaID, TeamLeaderRecruitment teamLeaderRecruitment, String description){
        this.teamLeaderRecruitment = teamLeaderRecruitment;
        this.projectIdeaID = projectIdeaID;
        this.description = description;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }

    public TeamLeaderRecruitment getTeamLeaderRecruitment(){
        return teamLeaderRecruitment;
    }

    public String getDescription() { return description; }

}
