package pl.edu.knbit.organizer.aggregateRoots.projectIdea.commands;

import pl.edu.knbit.organizer.aggregateRoots.projectIdea.entities.MemberID;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.valueObjects.ProjectIdeaID;

/**
 * Created by eric
 */

public class AcceptTeamLeaderCommand {

    private final MemberID leader;
    private final ProjectIdeaID projectIdeaID;

    public AcceptTeamLeaderCommand(MemberID leader, ProjectIdeaID projectIdeaID) {
        this.leader = leader;
        this.projectIdeaID = projectIdeaID;
    }

    public MemberID getLeader() {
        return leader;
    }

    public ProjectIdeaID getProjectIdeaID() {
        return projectIdeaID;
    }


}
