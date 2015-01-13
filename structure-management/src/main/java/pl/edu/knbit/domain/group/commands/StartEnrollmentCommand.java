package pl.edu.knbit.domain.group.commands;

import pl.edu.knbit.domain.group.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class StartEnrollmentCommand {
    private GroupId group;

    public StartEnrollmentCommand(GroupId group) {
        this.group = group;
    }

    public GroupId getGroup() {
        return group;
    }
}
