package pl.edu.knbit.domain.group.events;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.group.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class GroupCreatedEvent{
    @TargetAggregateIdentifier
    private final GroupId groupId;
    private final String name;
    private final String description;


    public GroupCreatedEvent(GroupId groupId, String name, String description) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
