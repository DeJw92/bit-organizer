package pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.entities.MemberID;

/**
 * Created by eric on 12/31/14.
 */

public class TeamLeaderAcceptedEvent {

    private final MemberID leader;

    public TeamLeaderAcceptedEvent(MemberID leader){
        this.leader = leader;
    }

    public MemberID getLeader(){
        return leader;
    }

}
