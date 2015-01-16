package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.commands;

import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;

/**
 * Created by zurek on 06.01.15.
 */
public class OpenTeamLeaderRecruitmentCommand extends AbstractTeamRecruitmentCommand {

    public OpenTeamLeaderRecruitmentCommand(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        super(teamLeaderRecruitmentId);
    }
}
