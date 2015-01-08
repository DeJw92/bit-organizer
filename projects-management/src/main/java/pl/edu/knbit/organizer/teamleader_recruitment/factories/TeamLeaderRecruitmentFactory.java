package pl.edu.knbit.organizer.teamleader_recruitment.factories;

import pl.edu.knbit.organizer.teamleader_recruitment.TeamLeaderRecruitment;
import pl.edu.knbit.organizer.teamleader_recruitment.value_objects.TeamLeaderRecruitmentId;

/**
 * Created by Tomasz Chmielarz, Bartosz Zurkowski on 08.01.15.
 */
public class TeamLeaderRecruitmentFactory {

    public static TeamLeaderRecruitment createTeamLeaderRecruitment(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        return new TeamLeaderRecruitment(teamLeaderRecruitmentId);
    }
}
