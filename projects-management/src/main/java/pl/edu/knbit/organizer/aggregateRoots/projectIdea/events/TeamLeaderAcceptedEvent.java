package pl.edu.knbit.organizer.aggregateRoots.projectIdea.events;

import pl.edu.knbit.organizer.aggregateRoots.projectIdea.entities.MemberID;

/**
 * Created by eric on 12/31/14.
 */

public class TeamLeaderAcceptedEvent {

    private final MemberID leader;

    public TeamLeaderAcceptedEvent(MemberID leader) {
        this.leader = leader;
    }

    public MemberID getLeader() {
        return leader;
    }

}
