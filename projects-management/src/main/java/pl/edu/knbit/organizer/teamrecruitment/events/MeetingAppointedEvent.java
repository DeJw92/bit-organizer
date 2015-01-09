package pl.edu.knbit.organizer.teamrecruitment.events;

import pl.edu.knbit.organizer.teamrecruitment.MemberId;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentId;

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
