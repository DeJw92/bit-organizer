package ddd.domain.commands;

import ddd.domain.entities.Member;
import ddd.domain.value_objects.ProjectIdeaID;

/**
 * Created by eric
 */

public class AcceptTeamLeaderCommand{

    private final Member leader;
    private final ProjectIdeaID projectIdeaID;

    public AcceptTeamLeaderCommand(Member leader, ProjectIdeaID projectIdeaID){
        this.leader = leader;
        this.projectIdeaID = projectIdeaID;
    }

    public Member getLeader(){
        return leader;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }


}
