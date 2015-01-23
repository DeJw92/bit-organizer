package pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.events;

import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.valueObjects.TeamLeaderRecruitmentId;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class TeamLeaderRecruitmentOpenedEvent extends AbstractTeamLeaderRecruitmentEvent {

    public TeamLeaderRecruitmentOpenedEvent(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        super(teamLeaderRecruitmentId);
    }
}
