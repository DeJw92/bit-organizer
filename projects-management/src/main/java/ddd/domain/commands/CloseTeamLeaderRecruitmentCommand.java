package ddd.domain.commands;

import ddd.domain.value_objects.ProjectIdeaID;

/**
 * Created by eric on 1/1/15.
 */
public class CloseTeamLeaderRecruitmentCommand {

    private final ProjectIdeaID projectIdeaID;

    public CloseTeamLeaderRecruitmentCommand(ProjectIdeaID projectIdeaID){
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }
}
