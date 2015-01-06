package pl.edu.knbit.organizer.teamleader_recruitment;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.organizer.teamleader_recruitment.entities.Member;
import pl.edu.knbit.organizer.teamleader_recruitment.events.CandidateAppliedEvent;
import pl.edu.knbit.organizer.teamleader_recruitment.events.TeamLeaderRecruitmentOpenedEvent;
import pl.edu.knbit.organizer.teamleader_recruitment.events.TeamLeaderSelectedEvent;
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

    private List<Member> candidates;

    private TeamLeaderRecruitmentStatus status;

    private TeamLeaderRecruitment() {
    }

    public TeamLeaderRecruitment(TeamLeaderRecruitmentId id) {
        apply(new TeamLeaderRecruitmentOpenedEvent(id));
    }

    public void applyForTeamLeader(Member candidate) {
        if (status == TeamLeaderRecruitmentStatus.OPENED)
            apply(new CandidateAppliedEvent(id, candidate));
    }

    public void selectTeamLeader(Member teamLeader) {
        if (status == TeamLeaderRecruitmentStatus.OPENED)
            apply(new TeamLeaderSelectedEvent(id, teamLeader));
    }

    @EventSourcingHandler
    public void onTeamLeaderRecruitmentOpened(TeamLeaderRecruitmentOpenedEvent event) {
        this.id = event.getTeamLeaderRecruitmentId();
        this.candidates = new ArrayList<Member>();
        this.status = TeamLeaderRecruitmentStatus.OPENED;
    }

    @EventSourcingHandler
    public void onCandidateApplied(CandidateAppliedEvent event) {
        candidates.add(event.getCandidate());
    }

    @EventSourcingHandler
    public void onTeamLeaderSelected(TeamLeaderSelectedEvent event) {
        candidates.remove(event.getTeamLeader());
        status = TeamLeaderRecruitmentStatus.CLOSED;
    }
}
