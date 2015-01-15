package pl.edu.knbit.domain.commands.group;

import pl.edu.knbit.domain.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class CreateGroupEnrollmentCommand {
    private final GroupId group;

    // TODO more arguments for Enrollment constructor
    public CreateGroupEnrollmentCommand(GroupId group) {
        this.group = group;
    }

    public GroupId getGroupId() {
        return group;
    }
}
