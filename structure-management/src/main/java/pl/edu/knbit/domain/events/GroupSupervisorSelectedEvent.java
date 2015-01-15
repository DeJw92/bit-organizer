package pl.edu.knbit.domain.events;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.MemberId;

/**
 * Created by mwrona.
 */
public class GroupSupervisorSelectedEvent {
    @TargetAggregateIdentifier
    private final GroupId groupId;
    private final MemberId groupSupervisor;

    public GroupSupervisorSelectedEvent(GroupId groupId, MemberId groupSupervisor) {
        this.groupId = groupId;
        this.groupSupervisor = groupSupervisor;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public MemberId getGroupSupervisor() {
        return groupSupervisor;
    }
}
