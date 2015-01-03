package pl.edu.knbit.organizer;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import java.util.ArrayList;
import java.util.List;

public class TeamRecruitment extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private TeamRecruitmentId id;
    private List<MemberId> appliedMembers = new ArrayList<>();
    private TeamRecruitmentStatus status;

    private TeamRecruitment() {
    }

    public TeamRecruitment(TeamRecruitmentId id, List<MemberId> appliedMembers, TeamRecruitmentStatus status) {
        this.id = id;
        this.appliedMembers = appliedMembers;
        this.status = status;
    }
}
