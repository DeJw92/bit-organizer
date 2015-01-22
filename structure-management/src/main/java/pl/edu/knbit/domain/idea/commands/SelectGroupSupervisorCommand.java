package pl.edu.knbit.domain.idea.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.member.valueobjects.MemberId;
import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class SelectGroupSupervisorCommand {
    @TargetAggregateIdentifier
    private final IdeaId ideaId;
    private final GroupId groupId;
    private final MemberId groupSupervisorId;

    public SelectGroupSupervisorCommand(IdeaId ideaId, GroupId groupId, MemberId groupSupervisorId) {
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

    public MemberId getGroupSupervisorId() {
        return groupSupervisorId;
    }
}
