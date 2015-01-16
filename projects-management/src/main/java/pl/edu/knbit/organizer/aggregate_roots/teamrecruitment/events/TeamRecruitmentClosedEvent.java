package pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.events;

import pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.TeamRecruitmentId;

public class TeamRecruitmentClosedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentClosedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }
    
}
