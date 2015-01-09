package pl.edu.knbit.domain.aggregates;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import pl.edu.knbit.domain.events.EnrollmentStartedEvent;
import pl.edu.knbit.domain.events.GroupCreatedEvent;
import pl.edu.knbit.domain.events.MemberAddedEvent;
import pl.edu.knbit.domain.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.UserId;

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
    private UserId groupSupervisor;
    private Set<UserId> members;
    private EnrollmentId enrollment;

    public Group() {
    }

    public Group(GroupId groupId, GroupId parentGroup, String name, String description, UserId groupSupervisor) {
        apply(new GroupCreatedEvent(groupId, parentGroup, name, description, groupSupervisor));
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public GroupId getParentGroup() {
        return parentGroup;
    }

    public Set<GroupId> getSubgroups() {
        return Collections.unmodifiableSet(subgroups);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<UserId> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    public UserId getGroupSupervisor() {
        return groupSupervisor;
    }

    public void addMember(UserId member){
        apply(new MemberAddedEvent(groupId, member));
    }

    public void startEnrollment(){
        apply(new EnrollmentStartedEvent(groupId));
    }

    @EventSourcingHandler
    public void onGroupCreated(GroupCreatedEvent groupCreatedEvent){
        this.groupId = groupCreatedEvent.getGroupId();
        this.parentGroup = groupCreatedEvent.getParentGroup();
        this.name = groupCreatedEvent.getName();
        this.description = groupCreatedEvent.getDescription();
        this.groupSupervisor = groupCreatedEvent.getGroupSupervisor();
        this.subgroups = new HashSet<>();
        this.members = new HashSet<>();
        addMember(this.groupSupervisor);
    }

    @EventSourcingHandler
    public void onMemberAdded(MemberAddedEvent memberAddedEvent){
        members.add(memberAddedEvent.getUser());
//        if (parentGroup != null) {
//            apply(new MemberAddedEvent(parentGroup, memberAddedEvent.getUser()));
//        }
    }

    @EventSourcingHandler
    public void onStartEnrollment(EnrollmentStartedEvent enrollmentStartedEvent){
        //TODO
    }

}
