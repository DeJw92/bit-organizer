package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;

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
