package pl.edu.knbit.domain.group.commands;

import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.member.valueobject.MemberId;

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
