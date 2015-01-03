package pl.edu.knbit.organizer.events;

import pl.edu.knbit.organizer.TeamRecruitmentId;

public class TeamRecruitmentFinishedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentFinishedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }
    
}
