package agh.ddd.memebershiprequest.domain;

import agh.ddd.memebershiprequest.domain.commands.AcceptMembershipRequestCommand;
import agh.ddd.memebershiprequest.domain.commands.DenyMembershipRequestCommand;
import agh.ddd.memebershiprequest.domain.events.MembershipRequestAcceptedEvent;
import agh.ddd.memebershiprequest.domain.events.MembershipRequestDeniedEvent;
import agh.ddd.memebershiprequest.domain.valueobjects.MembershipRequestId;
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


