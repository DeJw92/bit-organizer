package pl.edu.knbit.organizer.teamleader_recruitment;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import pl.edu.knbit.organizer.teamleader_recruitment.entities.Member;
import pl.edu.knbit.organizer.teamleader_recruitment.events.TeamLeaderRecruitmentOpenedEvent;
import pl.edu.knbit.organizer.teamleader_recruitment.value_objects.MemberId;
import pl.edu.knbit.organizer.teamleader_recruitment.value_objects.TeamLeaderRecruitmentId;
import pl.edu.knbit.organizer.teamleader_recruitment.value_objects.TeamLeaderRecruitmentStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class TeamLeaderRecruitment extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private TeamLeaderRecruitmentId id;

    private List<Member> appliedMembers = new ArrayList<Member>();

    private TeamLeaderRecruitmentStatus status = TeamLeaderRecruitmentStatus.OPEN;

    private TeamLeaderRecruitment() {
    }

    public TeamLeaderRecruitment(TeamLeaderRecruitmentId id) {
        apply(new TeamLeaderRecruitmentOpenedEvent(id));
    }
}
