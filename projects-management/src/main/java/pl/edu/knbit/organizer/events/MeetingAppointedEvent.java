package pl.edu.knbit.organizer.events;

import pl.edu.knbit.organizer.MemberId;
import pl.edu.knbit.organizer.TeamRecruitmentId;

public class MeetingAppointedEvent {

    private final MemberId memberId;

    public MeetingAppointedEvent(MemberId memberId) {
        this.memberId = memberId;
    }

    public MemberId getMemberId() {
        return memberId;
    }
}
