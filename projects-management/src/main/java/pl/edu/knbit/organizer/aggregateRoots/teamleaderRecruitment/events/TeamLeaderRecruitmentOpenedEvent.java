package pl.edu.knbit.organizer.aggregateRoots.teamleaderRecruitment.events;

import pl.edu.knbit.organizer.aggregateRoots.teamleaderRecruitment.valueObjects.TeamLeaderRecruitmentId;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class TeamLeaderRecruitmentOpenedEvent extends AbstractTeamLeaderRecruitmentEvent {

    public TeamLeaderRecruitmentOpenedEvent(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        super(teamLeaderRecruitmentId);
    }
}
