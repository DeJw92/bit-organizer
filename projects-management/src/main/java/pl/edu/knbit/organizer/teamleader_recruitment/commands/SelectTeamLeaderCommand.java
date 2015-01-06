package pl.edu.knbit.organizer.teamleader_recruitment.commands;

import pl.edu.knbit.organizer.teamleader_recruitment.entities.Member;
import pl.edu.knbit.organizer.teamleader_recruitment.value_objects.TeamLeaderRecruitmentId;

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
