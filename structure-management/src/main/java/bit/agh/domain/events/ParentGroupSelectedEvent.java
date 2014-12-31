package bit.agh.domain.events;

import bit.agh.domain.valueobjects.GroupId;
import bit.agh.domain.valueobjects.IdeaId;
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
