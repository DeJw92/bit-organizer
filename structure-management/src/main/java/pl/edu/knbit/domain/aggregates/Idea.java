package pl.edu.knbit.domain.aggregates;

import pl.edu.knbit.domain.events.IdeaCreatedEvent;
import pl.edu.knbit.domain.events.ParentGroupSelectedEvent;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

public class Idea extends AbstractAnnotatedAggregateRoot {
    @AggregateIdentifier
    private IdeaId id;
    private String title;
    private String description;
    private GroupId parentGroupId;

    private Idea() {
    }

    public Idea(IdeaId id, String title, String description) {
        apply(new IdeaCreatedEvent(id, title, description));
    }

    public void selectParentGroup(GroupId groupId) {
        this.parentGroupId = groupId;
        apply(new ParentGroupSelectedEvent(this.id, this.parentGroupId));
    }

    @EventSourcingHandler
    public void onIdeaCreated(IdeaCreatedEvent ideaCreatedEvent) {
        this.id = ideaCreatedEvent.getIdeaId();
        this.title = ideaCreatedEvent.getTitle();
        this.description = ideaCreatedEvent.getDescription();
    }

    @EventSourcingHandler
    public void onParentGroupSelected(ParentGroupSelectedEvent parentGroupSelectedEvent) {
        this.parentGroupId = parentGroupSelectedEvent.getParentGroupId();
    }
}
