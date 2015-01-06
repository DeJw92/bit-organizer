package pl.edu.knbit.organizer.teamleader_recruitment.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.organizer.teamleader_recruitment.value_objects.TeamLeaderRecruitmentId;

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
