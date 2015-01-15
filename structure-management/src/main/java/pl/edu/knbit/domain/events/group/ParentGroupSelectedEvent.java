package pl.edu.knbit.domain.events.group;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class ParentGroupSelectedEvent {
    @TargetAggregateIdentifier
    private final GroupId groupId;
    private final GroupId parentGroup;

    public ParentGroupSelectedEvent(GroupId groupId, GroupId parentGroup) {
        this.groupId = groupId;
        this.parentGroup = parentGroup;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public GroupId getParentGroup() {
        return parentGroup;
    }
}