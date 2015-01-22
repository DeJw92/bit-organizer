package pl.edu.knbit.domain.group.commands;

import pl.edu.knbit.domain.group.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class SelectParentGroupCommand {
    private final GroupId groupId;
    private final GroupId parentGroup;

    public SelectParentGroupCommand(GroupId groupId, GroupId parentGroup) {
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
