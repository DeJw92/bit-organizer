package pl.edu.knbit.domain.group.events;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.common.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class EnrollmentCreatedEvent {
    @TargetAggregateIdentifier
    private final GroupId groupId;

    public EnrollmentCreatedEvent(GroupId groupId) {
        this.groupId = groupId;
    }

    public GroupId getGroupId() {
        return groupId;
    }
}
