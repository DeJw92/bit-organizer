package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class TeamLeaderRecruitmentOpenedEvent extends AbstractTeamLeaderRecruitmentEvent {

    public TeamLeaderRecruitmentOpenedEvent(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        super(teamLeaderRecruitmentId);
    }
}
