package bit.agh.domain.commands;

import bit.agh.domain.valueobjects.GroupId;
import bit.agh.domain.valueobjects.IdeaId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class SelectParentGroupCommand {
    @TargetAggregateIdentifier
    private final IdeaId ideaId;
    private final GroupId groupId;

    public SelectParentGroupCommand(IdeaId ideaId, GroupId groupId) {
        this.ideaId = ideaId;
        this.groupId = groupId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }

    public GroupId getGroupId() {
        return groupId;
    }
}
