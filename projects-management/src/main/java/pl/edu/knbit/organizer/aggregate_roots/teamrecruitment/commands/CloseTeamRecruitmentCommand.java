package pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.organizer.aggregate_roots.teamrecruitment.TeamRecruitmentId;

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
