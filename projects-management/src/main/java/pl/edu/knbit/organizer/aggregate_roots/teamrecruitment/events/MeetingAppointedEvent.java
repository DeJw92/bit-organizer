package pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.events;

import pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.MemberId;
import pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.TeamRecruitmentId;

public class MeetingAppointedEvent {

    private final TeamRecruitmentId teamRecruitmentId;

    private final MemberId memberId;

    public MeetingAppointedEvent(TeamRecruitmentId teamRecruitmentId, MemberId memberId) {
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
