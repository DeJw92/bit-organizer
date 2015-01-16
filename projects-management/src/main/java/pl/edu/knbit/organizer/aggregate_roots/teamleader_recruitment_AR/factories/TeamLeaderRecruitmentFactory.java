package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.factories;

import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.TeamLeaderRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;

/**
 * Created by Tomasz Chmielarz, Bartosz Zurkowski on 08.01.15.
 */
public class TeamLeaderRecruitmentFactory {

    public static TeamLeaderRecruitment createTeamLeaderRecruitment(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        return new TeamLeaderRecruitment(teamLeaderRecruitmentId);
    }
}
