package pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.events;

import pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.TeamRecruitmentId;

public class TeamRecruitmentFinishedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentFinishedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }
    
}
