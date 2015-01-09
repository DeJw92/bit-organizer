package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class EnrollmentStartedEvent {
    private GroupId group;

    public EnrollmentStartedEvent(GroupId group) {
        this.group = group;
    }

    public GroupId getGroup() {
        return group;
    }
}
