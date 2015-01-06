package ddd.domain.commands;


import ddd.domain.entities.TeamLeaderRecruitment;
import ddd.domain.value_objects.ProjectIdeaID;

import java.lang.String;

/**
 * Created by eric on 1/1/15.
 */
public class CreateProjectIdeaCommand {

    private final ProjectIdeaID projectIdeaID;
    private final TeamLeaderRecruitment teamLeaderRecruitment;
    private final String description;

    public CreateProjectIdeaCommand(ProjectIdeaID projectIdeaID, TeamLeaderRecruitment teamLeaderRecruitment, String description){
        this.projectIdeaID = projectIdeaID;
        this.teamLeaderRecruitment = teamLeaderRecruitment;
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
