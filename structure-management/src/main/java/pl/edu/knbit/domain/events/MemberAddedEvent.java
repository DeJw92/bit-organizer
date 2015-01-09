package pl.edu.knbit.domain.events;

import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.UserId;

/**
 * Created by mwrona.
 */
public class MemberAddedEvent {
    private final GroupId group;
    private final UserId user;

    public MemberAddedEvent(GroupId group, UserId user) {
        this.group = group;
        this.user = user;
    }

    public GroupId getGroup() {
        return group;
    }

    public UserId getUser() {
        return user;
    }
}
