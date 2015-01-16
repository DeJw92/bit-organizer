package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class AbstractTeamRecruitmentCommand {

    @TargetAggregateIdentifier
    private TeamLeaderRecruitmentId teamLeaderRecruitmentId;

    public AbstractTeamRecruitmentCommand(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        this.teamLeaderRecruitmentId = teamLeaderRecruitmentId;
    }

    public TeamLeaderRecruitmentId getTeamLeaderRecruitmentId() {
        return teamLeaderRecruitmentId;
    }
}
