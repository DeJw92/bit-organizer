package pl.edu.knbit.domain.events.idea;

import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
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
