package pl.edu.knbit.domain.events;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import pl.edu.knbit.domain.valueobjects.UserId;

public class GroupSupervisorSelectedEvent {
    @TargetAggregateIdentifier
    private final IdeaId ideaId;
    private final GroupId groupId;
    private final UserId groupSupervisorId;

    public GroupSupervisorSelectedEvent(IdeaId ideaId, GroupId groupId, UserId groupSupervisorId) {
        this.ideaId = ideaId;
        this.groupId = groupId;
        this.groupSupervisorId = groupSupervisorId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public UserId getGroupSupervisorId() {
        return groupSupervisorId;
    }
}
