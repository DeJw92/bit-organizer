package pl.edu.knbit.organizer.aggregateRoots.teamRecruitment.events;

import pl.edu.knbit.organizer.aggregateRoots.teamRecruitment.valueObjects.MemberId;
import pl.edu.knbit.organizer.aggregateRoots.teamRecruitment.valueObjects.TeamRecruitmentId;

public class MemberAcceptedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    private final MemberId memberId;

    public MemberAcceptedEvent(TeamRecruitmentId teamRecruitmentId, MemberId memberId) {
        this.teamRecruitmentId = teamRecruitmentId;
        this.memberId = memberId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }

    public MemberId getMemberId() {
        return memberId;
    }

}
