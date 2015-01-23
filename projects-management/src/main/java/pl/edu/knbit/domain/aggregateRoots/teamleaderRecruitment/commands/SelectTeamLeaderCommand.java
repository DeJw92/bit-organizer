package pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.commands;

import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.entities.Member;
import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.valueObjects.TeamLeaderRecruitmentId;

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
