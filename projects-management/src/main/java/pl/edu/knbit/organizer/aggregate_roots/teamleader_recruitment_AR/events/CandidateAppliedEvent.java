package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.entities.Member;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class CandidateAppliedEvent extends AbstractTeamLeaderRecruitmentEvent {

    private Member candidate;

    public CandidateAppliedEvent(TeamLeaderRecruitmentId teamLeaderRecruitmentId, Member candidate) {
        super(teamLeaderRecruitmentId);
        this.candidate = candidate;
    }

    public Member getCandidate() {
        return candidate;
    }
}
