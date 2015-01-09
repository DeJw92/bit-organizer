package pl.edu.knbit.organizer.teamrecruitment.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.organizer.teamrecruitment.MemberId;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentId;

public class AppointMeetingCommand {

    @TargetAggregateIdentifier
    private final TeamRecruitmentId teamRecruitmentId;
    private final MemberId memberId;
    //TODO: Date

    public AppointMeetingCommand(TeamRecruitmentId teamRecruitmentId, MemberId memberId) {
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
