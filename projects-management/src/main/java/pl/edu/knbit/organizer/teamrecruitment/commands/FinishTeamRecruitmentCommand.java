package pl.edu.knbit.organizer.teamrecruitment.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentId;

public class FinishTeamRecruitmentCommand {

    @TargetAggregateIdentifier
    private final TeamRecruitmentId teamRecruitmentId;

    public FinishTeamRecruitmentCommand(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }

}