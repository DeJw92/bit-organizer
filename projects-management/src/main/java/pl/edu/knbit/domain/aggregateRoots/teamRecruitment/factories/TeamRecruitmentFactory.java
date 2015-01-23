package pl.edu.knbit.domain.aggregateRoots.teamRecruitment.factories;

import pl.edu.knbit.domain.aggregateRoots.teamRecruitment.TeamRecruitment;
import pl.edu.knbit.domain.aggregateRoots.teamRecruitment.valueObjects.TeamRecruitmentId;

public class TeamRecruitmentFactory {

    public static TeamRecruitment createTeamRecruitment() {
        final TeamRecruitmentId id = TeamRecruitmentId.randomId();
        return new TeamRecruitment(id);
    }

}
