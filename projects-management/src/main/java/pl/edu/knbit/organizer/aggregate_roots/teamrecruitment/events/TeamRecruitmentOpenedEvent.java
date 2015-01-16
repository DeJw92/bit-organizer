package pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.events;

import pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.TeamRecruitmentId;

public class TeamRecruitmentOpenedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentOpenedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }
}
