package pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.events;

import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.valueObjects.TeamLeaderRecruitmentId;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class AbstractTeamLeaderRecruitmentEvent {

    private TeamLeaderRecruitmentId teamLeaderRecruitmentId;

    public AbstractTeamLeaderRecruitmentEvent(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        this.teamLeaderRecruitmentId = teamLeaderRecruitmentId;
    }

    public TeamLeaderRecruitmentId getTeamLeaderRecruitmentId() {
        return teamLeaderRecruitmentId;
    }
}
