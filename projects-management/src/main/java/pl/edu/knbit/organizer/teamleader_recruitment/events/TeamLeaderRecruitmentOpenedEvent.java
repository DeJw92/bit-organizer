package pl.edu.knbit.organizer.teamleader_recruitment.events;

import pl.edu.knbit.organizer.teamleader_recruitment.entities.Member;
import pl.edu.knbit.organizer.teamleader_recruitment.value_objects.TeamLeaderRecruitmentId;

import java.util.List;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class TeamLeaderRecruitmentOpenedEvent extends AbstractTeamLeaderRecruitmentEvent {

    public TeamLeaderRecruitmentOpenedEvent(TeamLeaderRecruitmentId teamLeaderRecruitmentId) {
        super(teamLeaderRecruitmentId);
    }
}
