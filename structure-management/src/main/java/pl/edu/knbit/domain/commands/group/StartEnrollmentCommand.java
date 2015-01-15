package pl.edu.knbit.domain.commands.group;

import pl.edu.knbit.domain.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class StartEnrollmentCommand {
    private final GroupId group;

    public StartEnrollmentCommand(GroupId group) {
        this.group = group;
    }

    public GroupId getGroupId() {
        return group;
    }
}
