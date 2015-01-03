package pl.edu.knbit.organizer.events;

import pl.edu.knbit.organizer.TeamRecruitmentId;

public class TeamRecruitmentClosedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentClosedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }
    
}
