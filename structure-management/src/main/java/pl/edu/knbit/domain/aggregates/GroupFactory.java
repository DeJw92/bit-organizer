package pl.edu.knbit.domain.aggregates;

import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.UserId;

/**
 * Created by mwrona.
 */
public class GroupFactory {

    public static Group create(GroupId groupId, GroupId parentGroup, String name, String description, UserId groupSupervisor){
        return new Group(groupId, parentGroup, name, description, groupSupervisor);
    }
}
