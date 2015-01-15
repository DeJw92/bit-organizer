package agh.ddd.memebershiprequest.domain;

import agh.ddd.memebershiprequest.domain.commands.AcceptMembershipRequestCommand;
import agh.ddd.memebershiprequest.domain.commands.DenyMembershipRequestCommand;
import agh.ddd.memebershiprequest.domain.events.MembershipRequestAcceptedEvent;
import agh.ddd.memebershiprequest.domain.events.MembershipRequestDeniedEvent;
import agh.ddd.memebershiprequest.domain.valueobjects.MembershipRequestId;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by mypood on 11/01/15.
 */
public class MembershipRequestTest {

    private FixtureConfiguration fixture;

    public MembershipRequestTest() {
    }

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(MembershipRequest.class);
    }


    @Test
    public void testAcceptMembershipRequest() throws Exception {
        fixture.given()
                .when(new AcceptMembershipRequestCommand(MembershipRequestId.of("accept1"), "need to implement the aggregate"))
                .expectEvents(new MembershipRequestAcceptedEvent(MembershipRequestId.of("accept1"), "need to implement the aggregate"));
    }

    @Test
    public void testDenyMembershipRequest() throws Exception {
        fixture.given()
                .when(new DenyMembershipRequestCommand(MembershipRequestId.of("deny1"), "need to implement the aggregate"))
                .expectEvents(new MembershipRequestDeniedEvent(MembershipRequestId.of("deny1"), "need to implement the aggregate"));
    }












}
