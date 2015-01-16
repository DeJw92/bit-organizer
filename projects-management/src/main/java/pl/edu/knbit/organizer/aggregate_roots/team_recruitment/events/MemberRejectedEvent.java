package pl.edu.knbit.organizer.aggregate_roots.team_recruitment.events;

import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.value_objects.MemberId;
import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.value_objects.TeamRecruitmentId;

public class MemberRejectedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    private final MemberId memberId;

    public MemberRejectedEvent(TeamRecruitmentId teamRecruitmentId, MemberId memberId) {
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
