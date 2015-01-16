package pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.MemberId;
import pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.TeamRecruitmentId;

public class RejectMemberCommand {

    @TargetAggregateIdentifier
    private final TeamRecruitmentId teamRecruitmentId;

    private final MemberId memberId;

    public RejectMemberCommand(TeamRecruitmentId teamRecruitmentId, MemberId memberId) {
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