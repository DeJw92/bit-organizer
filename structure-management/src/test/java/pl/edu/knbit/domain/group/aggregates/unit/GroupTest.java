package pl.edu.knbit.domain.group.aggregates.unit;

import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.group.aggregates.Group;
import pl.edu.knbit.domain.group.aggregates.GroupFactory;
import pl.edu.knbit.domain.group.events.*;
import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.member.valueobjects.MemberId;

import java.util.UUID;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Created by Mateusz Paciorek
 */
public class GroupTest {

    private Group group;
    private GroupId groupId;
    private String name;
    private String description;
    private MemberId member;
    private GroupId parentGroup;
    private GroupId subgroup;

    @Before
    public void setUp() {
        groupId = new GroupId(UUID.randomUUID());
        name = "some_name";
        description = "some_description";
        member = new MemberId(UUID.randomUUID());
        parentGroup = new GroupId(UUID.randomUUID());
        subgroup = new GroupId(UUID.randomUUID());
        group = GroupFactory.create(groupId, name, description);
        group.onGroupCreated(new GroupCreatedEvent(groupId, name, description));

    }

    @Test
    public void shouldConstructorSetGroupIdProperly() {
        // given
        // when
        Group group = new Group(groupId, name, description);
        group.onGroupCreated(new GroupCreatedEvent(groupId, name, description));
        // then
        assertThat(group.getGroupId()).isEqualTo(groupId);
    }

    @Test
    public void shouldConstructorSetNameProperly() {
        // given
        // when
        Group group = new Group(groupId, name, description);
        group.onGroupCreated(new GroupCreatedEvent(groupId, name, description));
        // then
        assertThat(group.getName()).isEqualTo(name);
    }

    @Test
    public void shouldConstructorSetDescriptionProperly() {
        // given
        // when
        Group group = new Group(groupId, name, description);
        group.onGroupCreated(new GroupCreatedEvent(groupId, name, description));
        // then
        assertThat(group.getDescription()).isEqualTo(description);
    }

    @Test(expected = NullPointerException.class)
    public void shouldConstructorThrowExceptionWhenGroupIdIsNull() {
        // given
        // when
       new Group(null, name, description);
        // then
        // expect NullPointerException
    }

    @Test(expected = NullPointerException.class)
    public void shouldConstructorThrowExceptionWhenNameIsNull() {
        // given
        // when
        new Group(groupId, null, description);
        // then
        // expect NullPointerException
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldConstructorThrowExceptionWhenNameIsEmpty() {
        // given
        // when
        new Group(groupId, "", description);
        // then
        // expect IllegalArgumentException
    }

    @Test(expected = NullPointerException.class)
    public void shouldConstructorThrowExceptionWhenDescriptionIsNull() {
        // given
        // when
        new Group(groupId, name, null);
        // then
        // expect NullPointerException
    }

    @Test(expected = NullPointerException.class)
    public void shouldAddMemberThrowExceptionWhenMemberIsNull() {
        // given
        // when
        group.addMember(null);
        // then
        // expect NullPointerException
    }

    @Test(expected = NullPointerException.class)
    public void shouldSelectParentGroupThrowExceptionWhenParentGroupIsNull() {
        // given
        // when
        group.selectParentGroup(null);
        // then
        // expect NullPointerException
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldSelectParentGroupThrowExceptionWhenParentGroupIsEqualToGroup() {
        // given
        // when
        group.selectParentGroup(groupId);
        // then
        // expect IllegalArgumentException
    }

    @Test(expected = NullPointerException.class)
    public void shouldSelectGroupSupervisorThrowExceptionWhenGroupSupervisorIsNull() {
        // given
        // when
        group.selectGroupSupervisor(null);
        // then
        // expect NullPointerException
    }

    @Test
    public void shouldOnMemberAddedAddMemberToMembers() {
        // given
        // when
        group.onMemberAdded(new MemberAddedEvent(groupId, member));
        // then
        assertThat(group.getMembers()).containsOnly(member);
    }

    @Test
    public void shouldOnParentGroupSelectedSetParentGroupProperly() {
        // given
        // when
        group.onParentGroupSelected(new ParentGroupSelectedEvent(groupId, parentGroup));
        // then
        assertThat(group.getParentGroup()).isEqualTo(parentGroup);
    }

    @Test
    public void shouldOnGroupSupervisorSelectedSetGroupSupervisorProperly() {
        // given
        // when
        group.onGroupSupervisorSelected(new GroupSupervisorSelectedEvent(groupId, member));
        // then
        assertThat(group.getGroupSupervisor()).isEqualTo(member);
    }

    @Test
    public void shouldSubgroupAddedAddSubgroupProperly() {
        // given
        // when
        group.onSubgroupAdded(new SubgroupAddedEvent(groupId, subgroup));
        // then
        assertThat(group.getSubgroups()).containsOnly(subgroup);
    }
}
