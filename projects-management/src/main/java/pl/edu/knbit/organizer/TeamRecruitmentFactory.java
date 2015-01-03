package pl.edu.knbit.organizer;

import java.util.ArrayList;

public class TeamRecruitmentFactory {

    public static TeamRecruitment createTeamRecruitment() {
        final TeamRecruitmentId id = TeamRecruitmentId.randomId();
        return new TeamRecruitment(id, new ArrayList<MemberId>(), TeamRecruitmentStatus.OPEN);
    }

}
