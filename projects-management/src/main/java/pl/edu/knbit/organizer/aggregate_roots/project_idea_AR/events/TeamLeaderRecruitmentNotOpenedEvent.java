package pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.entities.MemberID;

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
