package ddd.domain.events;

import ddd.domain.entities.Member;

/**
 * Created by eric on 12/31/14.
 */

public class TeamLeaderAcceptedEvent {

    private final Member leader;

    public TeamLeaderAcceptedEvent(Member leader){
        this.leader = leader;
    }

    public Member getLeader(){
        return leader;
    }

}
