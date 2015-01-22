package pl.edu.knbit.domain.idea.events;

import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.idea.valueobjects.IdeaId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class ParentGroupSelectedEvent {
    @TargetAggregateIdentifier
    private final IdeaId id;
    private final GroupId parentGroupId;
    public ParentGroupSelectedEvent(IdeaId id, GroupId parentGroupId) {
        this.id = id;
        this.parentGroupId = parentGroupId;
    }

    public IdeaId getId() {
        return id;
    }

    public GroupId getParentGroupId() {
        return parentGroupId;
    }
}
