package pl.edu.knbit.domain.aggregates;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.domain.events.*;
import pl.edu.knbit.domain.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.MemberId;
import com.google.common.base.Preconditions;

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

    public void addMember(MemberId member){
        Preconditions.checkNotNull(member);

        apply(new MemberAddedEvent(groupId, member));
        if (parentGroup != null) {
            apply(new MemberAddedEvent(parentGroup, member));
        }
    }

    public void startEnrollment(){
        //TODO creating enrollment
        apply(new EnrollmentStartedEvent(groupId));
    }

    public void selectParentGroup(GroupId parentGroup) {
        Preconditions.checkNotNull(parentGroup);

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
    public void onStartEnrollment(EnrollmentStartedEvent enrollmentStartedEvent){
        //TODO assigning enrollment
    }

    @EventSourcingHandler
    public void onSelectParentGroup(ParentGroupSelectedEvent parentGroupSelectedEvent){
        this.parentGroup = parentGroupSelectedEvent.getParentGroup();
    }

    @EventSourcingHandler
    public void onSelectParentGroup(GroupSupervisorSelectedEvent groupSupervisorSelectedEvent){
        this.groupSupervisor = groupSupervisorSelectedEvent.getGroupSupervisor();
    }

    @EventSourcingHandler
    public void onAddSubgroup(SubgroupAddedEvent subgroupAddedEvent){
        this.subgroups.add(subgroupAddedEvent.getSubgroup());
    }
}
