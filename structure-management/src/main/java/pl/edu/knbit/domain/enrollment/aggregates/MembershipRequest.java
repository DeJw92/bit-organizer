package pl.edu.knbit.domain.enrollment.aggregates;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class MembershipRequest extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private pl.edu.knbit.domain.enrollment.valueobjects.MembershipRequestId id;

    private MembershipRequest() {}

    public MembershipRequest(pl.edu.knbit.domain.enrollment.valueobjects.MembershipRequestId id) {
        this.id = id;
    }

    public pl.edu.knbit.domain.enrollment.valueobjects.MembershipRequestId getId() {
        return id;
    }
}
