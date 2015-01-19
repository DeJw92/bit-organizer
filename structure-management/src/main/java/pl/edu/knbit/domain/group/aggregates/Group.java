package pl.edu.knbit.domain.group.aggregates;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.group.events.*;
import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.member.valueobjects.MemberId;
import com.google.common.base.Preconditions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mwrona.
 */
public class Group extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private GroupId groupId;
    private GroupId parentGroup;
    private Set<GroupId> subgroups;
    private String name;
    private String description;
    private MemberId groupSupervisor;
    private Set<MemberId> members;

    private EnrollmentId enrollment;

    public Group() {
    }

    public Group(GroupId groupId, String name, String description) {
        Preconditions.checkNotNull(groupId);
        Preconditions.checkNotNull(name);
        Preconditions.checkArgument(!name.isEmpty());
        Preconditions.checkNotNull(description);

        apply(new GroupCreatedEvent(groupId, name, description));
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<MemberId> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    public GroupId getParentGroup() {
        return parentGroup;
    }

    public Set<GroupId> getSubgroups() {
        return Collections.unmodifiableSet(subgroups);
    }

    public MemberId getGroupSupervisor() {
        return groupSupervisor;
    }

    public void addMember(MemberId member){
        Preconditions.checkNotNull(member);

        apply(new MemberAddedEvent(groupId, member));
        if (parentGroup != null) {
            apply(new MemberAddedEvent(parentGroup, member));
        }
    }

    // TODO arguments for Enrollment constructor
    public void startEnrollment(){
        // TODO creating enrollment
        apply(new EnrollmentCreatedEvent(groupId));
    }

    public void selectParentGroup(GroupId parentGroup) {
        Preconditions.checkNotNull(parentGroup);
        Preconditions.checkArgument(!parentGroup.equals(groupId));

        apply(new ParentGroupSelectedEvent(groupId, parentGroup));
        apply(new SubgroupAddedEvent(parentGroup, groupId));
    }

    public void selectGroupSupervisor(MemberId groupSupervisor) {
        Preconditions.checkNotNull(groupSupervisor);

        apply(new GroupSupervisorSelectedEvent(groupId, groupSupervisor));
    }

    @EventSourcingHandler
    public void onGroupCreated(GroupCreatedEvent groupCreatedEvent){
        this.groupId = groupCreatedEvent.getGroupId();
        this.name = groupCreatedEvent.getName();
        this.description = groupCreatedEvent.getDescription();
        this.subgroups = new HashSet<>();
        this.members = new HashSet<>();
    }

    @EventSourcingHandler
    public void onMemberAdded(MemberAddedEvent memberAddedEvent){
        members.add(memberAddedEvent.getMember());
    }

    @EventSourcingHandler
    public void onEnrollmentCreated(EnrollmentCreatedEvent enrollmentCreatedEvent){
        // TODO assign enrollment
    }

    @EventSourcingHandler
    public void onParentGroupSelected(ParentGroupSelectedEvent parentGroupSelectedEvent){
        this.parentGroup = parentGroupSelectedEvent.getParentGroup();
    }

    @EventSourcingHandler
    public void onGroupSupervisorSelected(GroupSupervisorSelectedEvent groupSupervisorSelectedEvent){
        this.groupSupervisor = groupSupervisorSelectedEvent.getGroupSupervisor();
    }

    @EventSourcingHandler
    public void onSubgroupAdded(SubgroupAddedEvent subgroupAddedEvent){
        this.subgroups.add(subgroupAddedEvent.getSubgroup());
    }
}
