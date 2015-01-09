package pl.edu.knbit.organizer.teamrecruitment.events;

import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentId;

public class TeamRecruitmentClosedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentClosedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }
    
}
