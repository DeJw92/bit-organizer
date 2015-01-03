package pl.edu.knbit.organizer;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import java.util.List;

public class TeamRecruitment extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private TeamRecruitmentId id;
    private List<MemberId> appliedMembers;
    private List<MemberId> acceptedMembers;
    private TeamRecruitmentStatus status;

    private TeamRecruitment() {
    }

    public TeamRecruitment(TeamRecruitmentId id, List<MemberId> appliedMembers, List<MemberId> acceptedMembers, TeamRecruitmentStatus status) {
        this.id = id;
        this.appliedMembers = appliedMembers;
        this.acceptedMembers = acceptedMembers;
        this.status = status;
    }
}
