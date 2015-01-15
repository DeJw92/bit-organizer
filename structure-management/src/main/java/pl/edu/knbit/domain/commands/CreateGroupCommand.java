package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.valueobjects.GroupId;


/**
 * Created by mwrona.
 */
public class CreateGroupCommand {
    private final GroupId groupId;
    private final String name;
    private final String description;

    public CreateGroupCommand(GroupId groupId, String name, String description) {
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
