package pl.edu.knbit.organizer.teamleader_recruitment.events;

import pl.edu.knbit.organizer.teamleader_recruitment.value_objects.TeamLeaderRecruitmentId;

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
