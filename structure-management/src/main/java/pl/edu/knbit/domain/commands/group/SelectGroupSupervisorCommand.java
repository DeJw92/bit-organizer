package pl.edu.knbit.domain.commands.group;

import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.MemberId;

/**
 * Created by mwrona.
 */
public class SelectGroupSupervisorCommand {
    private final GroupId groupId;
    public SelectGroupSupervisorCommand(GroupId groupId, MemberId groupSupervisor) {
        this.groupId = groupId;
        this.groupSupervisor = groupSupervisor;
    }

    private final MemberId groupSupervisor;

    public GroupId getGroupId() {
        return groupId;
    }

    public MemberId getGroupSupervisor() {
        return groupSupervisor;
    }
}
