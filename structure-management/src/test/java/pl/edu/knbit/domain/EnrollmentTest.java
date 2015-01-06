package pl.edu.knbit.domain;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.aggregates.Enrollment;
import pl.edu.knbit.domain.aggregates.MembershipRequest;
import pl.edu.knbit.domain.commands.AddMembershipRequestCommand;
import pl.edu.knbit.domain.commands.CancelEnrollmentCommand;
import pl.edu.knbit.domain.commands.CloseEnrollmentCommand;
import pl.edu.knbit.domain.commands.CreateEnrollmentCommand;
import pl.edu.knbit.domain.commands.handlers.EnrollmentCommandsHandler;
import pl.edu.knbit.domain.events.*;
import pl.edu.knbit.domain.valueobjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.EnrollmentStatus;
import pl.edu.knbit.domain.valueobjects.MembershipRequestId;

import java.util.UUID;

public class EnrollmentTest {

    private FixtureConfiguration fixtureConfiguration;
    private EnrollmentId enrollmentId;
    private String title;
    private String description;
    private EnrollmentConfiguration configuration;
    private MembershipRequest membershipRequest;
    private MembershipRequest membershipRequest2;
    private MembershipRequest membershipRequest3;

    @Before
    public void setUp() {
        fixtureConfiguration = Fixtures.newGivenWhenThenFixture(Enrollment.class);

        enrollmentId = new EnrollmentId(UUID.randomUUID());
        title = "Title";
        description = "Desc";
        configuration = new EnrollmentConfiguration(2);

        membershipRequest = new MembershipRequest(new MembershipRequestId(UUID.randomUUID()));
        membershipRequest2 = new MembershipRequest(new MembershipRequestId(UUID.randomUUID()));
        membershipRequest3 = new MembershipRequest(new MembershipRequestId(UUID.randomUUID()));

        EnrollmentCommandsHandler enrollmentCommandsHandler = new EnrollmentCommandsHandler();
        enrollmentCommandsHandler.setEnrollmentRepository(fixtureConfiguration.getRepository());
        fixtureConfiguration.registerAnnotatedCommandHandler(enrollmentCommandsHandler);
    }

    @Test
    public void testEnrollmentCreation() {
        fixtureConfiguration
                .given()
                .when(new CreateEnrollmentCommand(enrollmentId, title, description, configuration))
                .expectEvents(new EnrollmentCreatedEvent(enrollmentId, title, description, configuration));
    }

    @Test
    public void testEnrollmentCancellation() {
        fixtureConfiguration
                .given(new EnrollmentCreatedEvent(enrollmentId, title, description, configuration))
                .when(new CancelEnrollmentCommand(enrollmentId))
                .expectEvents(new EnrollmentCanceledEvent(enrollmentId));
    }

    @Test
    public void testEnrollmentClose() {
        fixtureConfiguration
                .given(new EnrollmentCreatedEvent(enrollmentId, title, description, configuration))
                .when(new CloseEnrollmentCommand(enrollmentId))
                .expectEvents(new EnrollmentClosedEvent(enrollmentId));
    }

    @Test
    public void testEnrollmentAddMembershipRequest() {
        fixtureConfiguration
                .given(new EnrollmentCreatedEvent(enrollmentId, title, description, configuration))
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequest))
                .expectEvents(new MembershipRequestAddedEvent(enrollmentId, membershipRequest));
    }

    @Test
    public void testEnrollmentAddMembershipRequestWhenFull() {
        fixtureConfiguration
                .given(
                        new EnrollmentCreatedEvent(enrollmentId, title, description, configuration),
                        new MembershipRequestAddedEvent(enrollmentId, membershipRequest2),
                        new MembershipRequestAddedEvent(enrollmentId, membershipRequest3)
                )
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequest))
                .expectEvents(new EnrollmentIsFullEvent(enrollmentId));
    }

    @Test
    public void testEnrollmentAddMembershipRequestWhenClosed() {
        fixtureConfiguration
                .given(
                        new EnrollmentCreatedEvent(enrollmentId, title, description, configuration),
                        new EnrollmentClosedEvent(enrollmentId)
                )
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequest))
                .expectEvents(new EnrollmentIsNotOpenedEvent(enrollmentId, EnrollmentStatus.CLOSED));
    }

    @Test
    public void testEnrollmentAddMembershipRequestWhenCanceled() {
        fixtureConfiguration
                .given(
                        new EnrollmentCreatedEvent(enrollmentId, title, description, configuration),
                        new EnrollmentCanceledEvent(enrollmentId)
                )
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequest))
                .expectEvents(new EnrollmentIsNotOpenedEvent(enrollmentId, EnrollmentStatus.CANCELED));
    }

    @Test
    public void testEnrollmentAddMembershipRequestTwice() {
        fixtureConfiguration
                .given(
                        new EnrollmentCreatedEvent(enrollmentId, title, description, configuration),
                        new MembershipRequestAddedEvent(enrollmentId, membershipRequest)
                )
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequest))
                .expectEvents(new EnrollmentAlreadyContainsMembershipRequestEvent(enrollmentId, membershipRequest));
    }
}
