package pl.edu.knbit.organizer.aggregateRoots.teamRecruitment.events;

import pl.edu.knbit.organizer.aggregateRoots.teamRecruitment.valueObjects.TeamRecruitmentId;

public class TeamRecruitmentClosedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentClosedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }

}
