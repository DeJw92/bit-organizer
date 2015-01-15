package pl.edu.knbit.domain.aggregates;

import pl.edu.knbit.domain.valueobjects.GroupId;

/**
 * Created by mwrona.
 */
public class GroupFactory {

    public static Group create(GroupId groupId, String name, String description){
        return new Group(groupId, name, description);
    }
}
