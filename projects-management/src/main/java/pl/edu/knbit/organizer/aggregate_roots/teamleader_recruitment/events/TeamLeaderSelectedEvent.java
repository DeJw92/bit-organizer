package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment.events;

import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment.value_objects.TeamLeaderRecruitmentId;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment.entities.Member;

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
