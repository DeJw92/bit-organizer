package pl.edu.knbit.domain.events.group;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class GroupEnrollmentCreatedEvent {
    @TargetAggregateIdentifier
    private final GroupId groupId;

    public GroupEnrollmentCreatedEvent(GroupId groupId) {
        this.groupId = groupId;
    }

    public GroupId getGroupId() {
        return groupId;
    }
}
