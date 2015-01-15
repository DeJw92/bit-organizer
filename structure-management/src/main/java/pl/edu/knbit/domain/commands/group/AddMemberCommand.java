package pl.edu.knbit.domain.commands.group;

import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.MemberId;

/**
 * Created by mwrona.
 */
public class AddMemberCommand {
    private final GroupId groupId;
    private final MemberId member;

    public AddMemberCommand(GroupId groupId, MemberId member) {
        this.groupId = groupId;
        this.member = member;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public MemberId getMember() {
        return member;
    }
}
