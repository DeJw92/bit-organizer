package ddd.domain.commands;


import ddd.domain.entities.TeamLeaderRecruitment;
import ddd.domain.value_objects.ProjectIdeaID;

/**
 * Created by eric on 1/1/15.
 */
public class CreateProjectIdeaCommand {

    private final ProjectIdeaID projectIdeaID;
    private final TeamLeaderRecruitment teamLeaderRecruitment;

    public CreateProjectIdeaCommand(ProjectIdeaID projectIdeaID, TeamLeaderRecruitment teamLeaderRecruitment){
        this.projectIdeaID = projectIdeaID;
        this.teamLeaderRecruitment = teamLeaderRecruitment;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }

    public TeamLeaderRecruitment getTeamLeaderRecruitment(){
        return teamLeaderRecruitment;
    }

}
