package pl.edu.knbit.domain.events.group;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class SubgroupAddedEvent {
    @TargetAggregateIdentifier
    private final GroupId groupId;
    private final GroupId subgroup;

    public SubgroupAddedEvent(GroupId groupId, GroupId subgroup) {
        this.groupId = groupId;
        this.subgroup = subgroup;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public GroupId getSubgroup() {
        return subgroup;
    }
}
