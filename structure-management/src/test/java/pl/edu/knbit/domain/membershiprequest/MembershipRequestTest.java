package pl.edu.knbit.domain.membershiprequest;

import pl.edu.knbit.domain.membershiprequest.commands.AcceptMembershipRequestCommand;
import pl.edu.knbit.domain.membershiprequest.commands.DenyMembershipRequestCommand;
import pl.edu.knbit.domain.membershiprequest.events.MembershipRequestAcceptedEvent;
import pl.edu.knbit.domain.membershiprequest.events.MembershipRequestDeniedEvent;
import pl.edu.knbit.domain.membershiprequest.valueobjects.MembershipRequestId;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;


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

        UUID test = UUID.randomUUID();
        System.out.print(test);
        fixture.given()
                .when(new AcceptMembershipRequestCommand(MembershipRequestId.of(test), "need to implement the aggregate"))
                .expectEvents(new MembershipRequestAcceptedEvent(MembershipRequestId.of(test), "need to implement the aggregate"));
    }

    @Test
    public void testDenyMembershipRequest() throws Exception {
        UUID test = UUID.randomUUID();

        fixture.given()
                .when(new DenyMembershipRequestCommand(MembershipRequestId.of(test), "need to implement the aggregate"))
                .expectEvents(new MembershipRequestDeniedEvent(MembershipRequestId.of(test), "need to implement the aggregate"));
    }












}
