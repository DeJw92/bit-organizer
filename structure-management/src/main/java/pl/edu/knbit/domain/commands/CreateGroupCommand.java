package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.UserId;


/**
 * Created by mwrona.
 */
public class CreateGroupCommand {
    private final GroupId groupId;
    private final GroupId parentGroup;
    private final String name;
    private final String description;
    private final UserId groupSupervisor;

    public CreateGroupCommand(GroupId groupId, GroupId parentGroup, String name, String description, UserId groupSupervisor) {
        this.groupId = groupId;
        this.parentGroup = parentGroup;
        this.name = name;
        this.description = description;
        this.groupSupervisor = groupSupervisor;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public GroupId getParentGroup() {
        return parentGroup;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UserId getGroupSupervisor() {
        return groupSupervisor;
    }
}
