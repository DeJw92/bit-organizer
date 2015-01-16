package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.entities.Member;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class TeamLeaderSelectedEvent extends AbstractTeamLeaderRecruitmentEvent {

    private Member teamLeader;

    public TeamLeaderSelectedEvent(TeamLeaderRecruitmentId teamLeaderRecruitmentId, Member teamLeader) {
        super(teamLeaderRecruitmentId);
        this.teamLeader = teamLeader;
    }

    public Member getTeamLeader() {
        return teamLeader;
    }
}
