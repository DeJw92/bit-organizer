package pl.edu.knbit.organizer.aggregateRoots.teamRecruitment.events;

import pl.edu.knbit.organizer.aggregateRoots.teamRecruitment.valueObjects.TeamRecruitmentId;

public class TeamRecruitmentFinishedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    public TeamRecruitmentFinishedEvent(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }

}
