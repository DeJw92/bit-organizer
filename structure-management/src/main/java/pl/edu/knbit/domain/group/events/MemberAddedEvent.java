package pl.edu.knbit.domain.group.events;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.group.valueobjects.MemberId;

/**
 * Created by mwrona.
 */
public class MemberAddedEvent {
    @TargetAggregateIdentifier
    private final GroupId groupId;
    private final MemberId member;

    public MemberAddedEvent(GroupId groupId, MemberId member) {
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
