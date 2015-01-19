package pl.edu.knbit.domain.membershiprequest;

import pl.edu.knbit.domain.membershiprequest.commands.AcceptMembershipRequestCommand;
import pl.edu.knbit.domain.membershiprequest.commands.DenyMembershipRequestCommand;
import pl.edu.knbit.domain.membershiprequest.events.MembershipRequestAcceptedEvent;
import pl.edu.knbit.domain.membershiprequest.events.MembershipRequestDeniedEvent;
import pl.edu.knbit.domain.membershiprequest.valueobjects.MembershipRequestId;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;


/**
 * Created by mypood on 11/01/15.
 */
public class MembershipRequest extends AbstractAnnotatedAggregateRoot {


    @AggregateIdentifier
    private MembershipRequestId id;

    public MembershipRequest() {
    }

    @CommandHandler
    public MembershipRequest(AcceptMembershipRequestCommand command){
        apply(new MembershipRequestAcceptedEvent(command.getMembershipRequestID(), command.getMemberID()));

    }

    @EventHandler
    public void onMembershipRequestAccepted(MembershipRequestAcceptedEvent event){
        this.id = event.getMembershipRequestID();
    }


    @CommandHandler
    public MembershipRequest(DenyMembershipRequestCommand command){
        apply(new MembershipRequestDeniedEvent(command.getMembershipRequestID(), command.getMemberID()));
    }

    @EventHandler
    public void onMembershipRequestRejected(MembershipRequestDeniedEvent event){
        this.id = event.getMembershipRequestID();
    }
}


