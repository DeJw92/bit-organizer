package pl.edu.knbit.domain.group.aggregates;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.group.commands.AddMemberCommand;
import pl.edu.knbit.domain.group.commands.CreateGroupCommand;
import pl.edu.knbit.domain.group.commands.StartEnrollmentCommand;
import pl.edu.knbit.domain.group.commands.handlers.GroupCommandHandler;
import pl.edu.knbit.domain.group.events.EnrollmentStartedEvent;
import pl.edu.knbit.domain.group.events.GroupCreatedEvent;
import pl.edu.knbit.domain.group.events.MemberAddedEvent;
import pl.edu.knbit.domain.group.valueObjects.GroupId;
import pl.edu.knbit.domain.group.valueObjects.UserId;

import java.util.UUID;

public class GroupTest {

    private FixtureConfiguration fixture;
    private GroupId groupId;
    private GroupId parentGroup;
    private String name;
    private String description;
    private UserId groupSupervisor;
    private UserId parentGroupSupervisor;
    private UserId member;

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
        parentGroupSupervisor = new UserId(UUID.randomUUID());
        groupSupervisor = new UserId(UUID.randomUUID());
        member = new UserId(UUID.randomUUID());
    }

    @Test
    public void testGroupCreation() {
        fixture
                .given()
                .when(
                        new CreateGroupCommand(groupId, null, name, description, groupSupervisor)
                )
                .expectEvents(
                        new GroupCreatedEvent(groupId, null, name, description, groupSupervisor),
                        new MemberAddedEvent(groupId, groupSupervisor)
                );
    }

//    @Test
//    public void testGroupOnCreateAddGroupSupervisorToParentGroup(){
//        fixture
//                .given(
//                        new GroupCreatedEvent(parentGroup, null, "aaa", description, parentGroupSupervisor)
//                )
//                .when(
//                        new CreateGroupCommand(groupId, parentGroup, "bbb", description, groupSupervisor)
//                )
//                .expectEvents(
//                        new GroupCreatedEvent(groupId, parentGroup, name, description, groupSupervisor),
//                        new MemberAddedEvent(groupId, groupSupervisor),
//                        new MemberAddedEvent(parentGroup, groupSupervisor)
//                );
//    }

    @Test
    public void testGroupAddMember() {
        fixture
                .given(
                        new GroupCreatedEvent(groupId, null, name, description, groupSupervisor)
                )
                .when(
                        new AddMemberCommand(groupId, member)
                )
                .expectEvents(
                        new MemberAddedEvent(groupId, member)
                );

    }
//
//    @Test
//    public void testGroupOnAddMemberAddAlsoToparentGroup() {
//        fixture
//                .given(
//                        new GroupCreatedEvent(parentGroup, null, name, description, parentGroupSupervisor),
//                        new GroupCreatedEvent(groupId, parentGroup, name, description, groupSupervisor)
//                )
//                .when(
//                        new AddMemberCommand(groupId, member)
//                )
//                .expectEvents(
//                        new MemberAddedEvent(groupId, member),
//                        new MemberAddedEvent(parentGroup, member)
//                );
//
//    }

    @Test
    public void testGroupStartEnrollment() {
        fixture
                .given(
                        new GroupCreatedEvent(groupId, parentGroup, name, description, groupSupervisor)
                )
                .when(
                        new StartEnrollmentCommand(groupId)
                ).expectEvents(
                new EnrollmentStartedEvent(groupId)
        );
    }

}