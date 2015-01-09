package pl.edu.knbit.organizer.teamrecruitment.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentId;

public class CloseTeamRecruitmentCommand {

    @TargetAggregateIdentifier
    private final TeamRecruitmentId teamRecruitmentId;

    public CloseTeamRecruitmentCommand(TeamRecruitmentId teamRecruitmentId) {
        this.teamRecruitmentId = teamRecruitmentId;
    }

    public TeamRecruitmentId getTeamRecruitmentId() {
        return teamRecruitmentId;
    }

}
