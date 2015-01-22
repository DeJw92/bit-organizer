package pl.edu.knbit.organizer.aggregateRoots.teamRecruitment.events;

import pl.edu.knbit.organizer.aggregateRoots.teamRecruitment.valueObjects.TeamRecruitmentId;

public class TeamRecruitmentOpenedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentOpenedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }
}
