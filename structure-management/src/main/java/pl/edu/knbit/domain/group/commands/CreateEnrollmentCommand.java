package pl.edu.knbit.domain.group.commands;

import pl.edu.knbit.domain.group.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class CreateEnrollmentCommand {
    private final GroupId group;

    // TODO more arguments for Enrollment constructor
    public CreateEnrollmentCommand(GroupId group) {
        this.group = group;
    }

    public GroupId getGroupId() {
        return group;
    }
}
