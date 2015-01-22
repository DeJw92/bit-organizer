package pl.edu.knbit.organizer.aggregate_roots.team_recruitment.events;

import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.value_objects.TeamRecruitmentId;

public class TeamRecruitmentOpenedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentOpenedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }
}
