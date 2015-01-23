package pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.factories;

import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.TeamLeaderRecruitment;
import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.valueObjects.TeamLeaderRecruitmentId;

/**
 * Created by Tomasz Chmielarz, Bartosz Zurkowski on 08.01.15.
 */
public class TeamLeaderRecruitmentFactory {

    public static TeamLeaderRecruitment createTeamLeaderRecruitment(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        return new TeamLeaderRecruitment(teamLeaderRecruitmentId);
    }
}
