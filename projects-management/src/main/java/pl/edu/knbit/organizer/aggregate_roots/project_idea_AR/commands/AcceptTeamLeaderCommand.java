package pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.commands;

import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.entities.MemberID;
import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.value_objects.ProjectIdeaID;

/**
 * Created by eric
 */

public class AcceptTeamLeaderCommand{

    private final MemberID leader;
    private final ProjectIdeaID projectIdeaID;

    public AcceptTeamLeaderCommand(MemberID leader, ProjectIdeaID projectIdeaID){
        this.leader = leader;
        this.projectIdeaID = projectIdeaID;
    }

    public MemberID getLeader(){
        return leader;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }


}
