package pl.edu.knbit.domain.group.aggregates;

import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.group.valueobjects.UserId;

/**
 * Created by mwrona.
 */
public class GroupFactory {

    public static Group create(GroupId groupId, GroupId parentGroup, String name, String description, UserId groupSupervisor){
        return new Group(groupId, parentGroup, name, description, groupSupervisor);
    }
}
