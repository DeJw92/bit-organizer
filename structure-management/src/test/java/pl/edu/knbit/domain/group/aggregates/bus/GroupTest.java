package pl.edu.knbit.domain.group.aggregates.bus;

import org.axonframework.test.Fixtures;
import org.axonframework.test.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.group.aggregates.Group;
import pl.edu.knbit.domain.group.commands.*;
import pl.edu.knbit.domain.group.commands.handlers.GroupCommandHandler;
import pl.edu.knbit.domain.group.events.*;
import pl.edu.knbit.domain.common.valueobjects.GroupId;
import pl.edu.knbit.domain.common.valueobjects.MemberId;


import java.util.UUID;

public class GroupTest {

    private FixtureConfiguration fixture;
    private GroupId groupId;
    private GroupId parentGroup;
    private String name;
    private String description;
    private MemberId member;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Group.class);

        GroupCommandHandler groupCommandHandler = new GroupCommandHandler();
        groupCommandHandler.setGroupRepository(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(groupCommandHandler);

        groupId = new GroupId(UUID.randomUUID());
        name = "name";
        description = "description";
        parentGroup = new GroupId(UUID.randomUUID());
        member = new MemberId(UUID.randomUUID());
    }

    @Test
    public void testGroupCreation() {
        fixture
                .given()
                .when(
                        new CreateGroupCommand(groupId, name, description)
                )
                .expectEvents(
                        new GroupCreatedEvent(groupId, name, description)
                );
    }

    @Test
    public void shouldGroupCreationFailWhenGroupIdIsNull() {
        fixture
                .given()
                .when(
                        new CreateGroupCommand(null, name, description)
                )
                .expectEvents(
                );
    }

    @Test
    public void shouldGroupCreationFailWhenNameIsNull() {
        fixture
                .given()
                .when(
                        new CreateGroupCommand(groupId, null, description)
                )
                .expectEvents(
                );
    }

    @Test
    public void shouldGroupCreationFailWhenNameIsEmpty() {
        fixture
                .given()
                .when(
                        new CreateGroupCommand(groupId, "", description)
                )
                .expectEvents(
                );
    }

    @Test
    public void shouldGroupCreationFailWhenDescriptionIsNull() {
        fixture
                .given()
                .when(
                        new CreateGroupCommand(groupId, name, null)
                )
                .expectEvents(
                );
    }

    @Test
    public void testGroupAddMember() {
        fixture
                .given(
                        new GroupCreatedEvent(groupId, name, description)
                )
                .when(
                        new AddMemberCommand(groupId, member)
                )
                .expectEvents(
                        new MemberAddedEvent(groupId, member)
                );
    }

    @Test
    public void shouldAddMemberFailWhenMemberIsNull() {
        fixture
                .given(
                        new GroupCreatedEvent(groupId, name, description)
                )
                .when(
                        new AddMemberCommand(groupId, null)
                )
                .expectEvents(
                );
    }

    @Test
    public void testGroupAddMemberShouldAlsoAddMemberToParentGroup() {
        fixture
                .given(
                        new GroupCreatedEvent(groupId, name, description),
                        new ParentGroupSelectedEvent(groupId, parentGroup)
                )
                .when(
                        new AddMemberCommand(groupId, member)
                )
                .expectEvents(
                        new MemberAddedEvent(groupId, member),
                        new MemberAddedEvent(parentGroup, member)
                );
    }

    @Test
    public void testGroupStartEnrollment() {
        fixture
                .given(
                        new GroupCreatedEvent(groupId, name, description)
                )
                .when(
                        new CreateEnrollmentCommand(groupId)
                ).expectEvents(
                        new EnrollmentCreatedEvent(groupId)
                );
    }

    @Test
    public void testGroupSelectParentGroup() {
        fixture
                .given(
                        new GroupCreatedEvent(groupId, name, description)
                )
                .when(
                        new SelectParentGroupCommand(groupId, parentGroup)
                )
                .expectEvents(
                        new ParentGroupSelectedEvent(groupId, parentGroup),
                        new SubgroupAddedEvent(parentGroup, groupId)
                );
    }

    @Test
    public void shouldSelectParentGroupFailWhenParentGroupIsNull() {
        fixture
                .given(
                        new GroupCreatedEvent(groupId, name, description)
                )
                .when(
                        new SelectParentGroupCommand(groupId, null)
                )
                .expectEvents(
                );
    }

    @Test
    public void shouldSelectParentGroupFailWhenSettingItselfAsParentGroup(){
        fixture
                .given(
                        new GroupCreatedEvent(groupId, name, description)
                )
                .when(
                        new SelectParentGroupCommand(groupId, groupId)
                )
                .expectEvents(
                );
    }

    @Test
    public void testGroupSelectGroupSupervisor(){
        fixture
                .given(
                        new GroupCreatedEvent(groupId, name, description)
                )
                .when(
                        new SelectGroupSupervisorCommand(groupId, member)
                )
                .expectEvents(
                        new GroupSupervisorSelectedEvent(groupId, member)
                );
    }

    @Test
    public void shouldSelectGroupSupervisorFailWhenGroupSupervisorIsNull(){
        fixture
                .given(
                        new GroupCreatedEvent(groupId, name, description)
                )
                .when(
                        new SelectGroupSupervisorCommand(groupId, null)
                )
                .expectEvents(
                );
    }
}