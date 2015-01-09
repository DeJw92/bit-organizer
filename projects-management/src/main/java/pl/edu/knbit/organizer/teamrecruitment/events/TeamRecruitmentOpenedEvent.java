package pl.edu.knbit.organizer.teamrecruitment.events;

import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentId;

public class TeamRecruitmentOpenedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentOpenedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }
}
