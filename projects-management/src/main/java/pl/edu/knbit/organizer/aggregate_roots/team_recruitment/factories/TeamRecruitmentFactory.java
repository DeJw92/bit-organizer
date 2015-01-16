package pl.edu.knbit.organizer.aggregate_roots.team_recruitment.factories;

import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.TeamRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.team_recruitment.value_objects.TeamRecruitmentId;

public class TeamRecruitmentFactory {

    public static TeamRecruitment createTeamRecruitment() {
        final TeamRecruitmentId id = TeamRecruitmentId.randomId();
        return new TeamRecruitment(id);
    }

}
