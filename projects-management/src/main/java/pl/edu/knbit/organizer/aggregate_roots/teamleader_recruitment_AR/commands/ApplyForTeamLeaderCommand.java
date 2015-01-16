package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.commands;

import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.entities.Member;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;

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