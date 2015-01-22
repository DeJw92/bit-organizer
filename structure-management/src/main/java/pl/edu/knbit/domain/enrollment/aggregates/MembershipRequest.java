package pl.edu.knbit.domain.enrollment.aggregates;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import pl.edu.knbit.domain.enrollment.valueobjects.MembershipRequestId;

public class MembershipRequest extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private MembershipRequestId id;

    private MembershipRequest() {
    }

    public MembershipRequest(MembershipRequestId id) {
        this.id = id;
    }

    public MembershipRequestId getId() {
        return id;
    }
}
