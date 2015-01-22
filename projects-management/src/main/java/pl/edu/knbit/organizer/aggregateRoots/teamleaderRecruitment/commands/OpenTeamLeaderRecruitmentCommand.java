package pl.edu.knbit.organizer.aggregateRoots.teamleaderRecruitment.commands;

import pl.edu.knbit.organizer.aggregateRoots.teamleaderRecruitment.valueObjects.TeamLeaderRecruitmentId;

/**
 * Created by zurek on 06.01.15.
 */
public class OpenTeamLeaderRecruitmentCommand extends AbstractTeamRecruitmentCommand {

    public OpenTeamLeaderRecruitmentCommand(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        super(teamLeaderRecruitmentId);
    }
}
