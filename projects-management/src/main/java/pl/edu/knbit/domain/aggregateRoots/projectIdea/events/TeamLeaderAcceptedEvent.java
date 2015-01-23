package pl.edu.knbit.domain.aggregateRoots.projectIdea.events;

import pl.edu.knbit.domain.aggregateRoots.projectIdea.entities.MemberID;

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
