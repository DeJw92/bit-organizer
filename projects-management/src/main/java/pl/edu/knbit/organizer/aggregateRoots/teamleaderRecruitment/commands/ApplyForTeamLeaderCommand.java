package pl.edu.knbit.organizer.aggregateRoots.teamleaderRecruitment.commands;

import pl.edu.knbit.organizer.aggregateRoots.teamleaderRecruitment.entities.Member;
import pl.edu.knbit.organizer.aggregateRoots.teamleaderRecruitment.valueObjects.TeamLeaderRecruitmentId;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class ApplyForTeamLeaderCommand extends AbstractTeamRecruitmentCommand {

    private Member candidate;

    public ApplyForTeamLeaderCommand(TeamLeaderRecruitmentId teamLeaderRecruitmentId, Member candidate) {
        super(teamLeaderRecruitmentId);
        this.candidate = candidate;
    }

    public Member getCandidate() {
        return candidate;
    }
}
