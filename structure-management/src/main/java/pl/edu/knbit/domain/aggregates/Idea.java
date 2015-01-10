package pl.edu.knbit.domain.aggregates;

import pl.edu.knbit.domain.events.IdeaAcceptedEvent;
import pl.edu.knbit.domain.events.GroupSupervisorSelectedEvent;
import pl.edu.knbit.domain.events.IdeaSubmittedEvent;
import pl.edu.knbit.domain.events.ParentGroupSelectedEvent;
import pl.edu.knbit.domain.exceptions.IdeaAlreadyAcceptedException;
import pl.edu.knbit.domain.exceptions.ParentGroupNotSelectedException;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.domain.valueobjects.UserId;

public class Idea extends AbstractAnnotatedAggregateRoot {
//    TODO
//    private static enum Status { SUBMITTED, ACCEPTED, REJECTED, ABANDONED }

    @AggregateIdentifier
    private IdeaId id;
    private String title;
    private String description;
    private GroupId parentGroupId;
    private boolean accepted = false;
    private UserId groupSupervisorId;

    private Idea() {
    }

    public Idea(IdeaId id, String title, String description) {
        apply(new IdeaSubmittedEvent(id, title, description));
    }

    public GroupId getParentGroupId() {
        return parentGroupId;
    }

    public void selectParentGroup(GroupId groupId) {
        //check whether group exists
        apply(new ParentGroupSelectedEvent(this.id, groupId));
    }

    public void accept() throws IdeaAlreadyAcceptedException {
        if(this.accepted){
            throw new IdeaAlreadyAcceptedException(this.id);
        }
        else{
            apply(new IdeaAcceptedEvent(this.id));
        }
    }

    public void selectGroupSupervisor(UserId groupSupervisorId) throws ParentGroupNotSelectedException {
        apply(new GroupSupervisorSelectedEvent(this.id, this.parentGroupId, groupSupervisorId));
    }

    @EventSourcingHandler
    public void onIdeaSubmitted(IdeaSubmittedEvent ideaSubmittedEvent) {
        this.id = ideaSubmittedEvent.getIdeaId();
        this.title = ideaSubmittedEvent.getTitle();
        this.description = ideaSubmittedEvent.getDescription();
    }

    @EventSourcingHandler
    public void onParentGroupSelected(ParentGroupSelectedEvent parentGroupSelectedEvent) {
        this.parentGroupId = parentGroupSelectedEvent.getParentGroupId();
    }
    @EventSourcingHandler
    public void onGroupSupervisorSelected(GroupSupervisorSelectedEvent groupSupervisorSelectedEvent) {
        this.groupSupervisorId = groupSupervisorSelectedEvent.getGroupSupervisorId();
    }

    @EventSourcingHandler
    public void onIdeaAccepted(IdeaAcceptedEvent ideaAcceptedEvent) {
        this.accepted = true;
    }
}
