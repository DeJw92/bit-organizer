package pl.edu.knbit.organizer.aggregate_roots.team_recruitment.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.value_objects.TeamRecruitmentId;

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
