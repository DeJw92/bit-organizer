package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.entities.Member;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events.CandidateAppliedEvent;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events.TeamLeaderRecruitmentOpenedEvent;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.events.TeamLeaderSelectedEvent;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentStatus;

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

    public List<Member> getCandidates() {
        return candidates;
    }
}
