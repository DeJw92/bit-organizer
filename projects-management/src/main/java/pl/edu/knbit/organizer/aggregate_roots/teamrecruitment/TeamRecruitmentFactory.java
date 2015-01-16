package pl.edu.knbit.organizer.aggregate_roots.teamrecruitment;

public class TeamRecruitmentFactory {

    public static TeamRecruitment createTeamRecruitment() {
        final TeamRecruitmentId id = TeamRecruitmentId.randomId();
        return new TeamRecruitment(id);
    }

}
