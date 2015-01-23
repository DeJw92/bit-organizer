package pl.edu.knbit.domain.aggregateRoots.projectIdea.events;

import pl.edu.knbit.domain.aggregateRoots.projectIdea.entities.MemberID;

/**
 * Created by Eryk on 2015-01-12.
 */
public class TeamLeaderRecruitmentNotOpenedEvent {

    private MemberID teamLeader;

    public TeamLeaderRecruitmentNotOpenedEvent(MemberID teamLeader) {
        this.teamLeader = teamLeader;
    }

    public MemberID getLeader() {
        return teamLeader;
    }
}
