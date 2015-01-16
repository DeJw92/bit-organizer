package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.commands;

import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.entities.Member;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class SelectTeamLeaderCommand extends AbstractTeamRecruitmentCommand {

    private Member teamLeader;

    public SelectTeamLeaderCommand(TeamLeaderRecruitmentId teamLeaderRecruitmentId, Member teamLeader) {
        super(teamLeaderRecruitmentId);
        this.teamLeader = teamLeader;
    }

    public Member getTeamLeader() {
        return teamLeader;
    }
}
