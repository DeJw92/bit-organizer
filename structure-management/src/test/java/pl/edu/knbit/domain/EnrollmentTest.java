package pl.edu.knbit.domain;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.aggregates.Enrollment;
import pl.edu.knbit.domain.commands.*;
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
    private MembershipRequestId membershipRequestId;
    private MembershipRequestId membershipRequestId2;
    private MembershipRequestId membershipRequestId3;

    @Before
    public void setUp() {
        fixtureConfiguration = Fixtures.newGivenWhenThenFixture(Enrollment.class);

        enrollmentId = new EnrollmentId();
        title = "Title";
        description = "Desc";
        configuration = new EnrollmentConfiguration(2);

        membershipRequestId = new pl.edu.knbit.domain.valueobjects.MembershipRequestId(UUID.randomUUID());
        membershipRequestId2 = new pl.edu.knbit.domain.valueobjects.MembershipRequestId(UUID.randomUUID());
        membershipRequestId3 = new pl.edu.knbit.domain.valueobjects.MembershipRequestId(UUID.randomUUID());

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
    public void testEnrollmentStart() {
        fixtureConfiguration
                .given(new EnrollmentCreatedEvent(enrollmentId, title, description, configuration))
                .when(new StartEnrollmentCommand(enrollmentId))
                .expectEvents(new EnrollmentStartedEvent(enrollmentId));
    }

    @Test
    public void testEnrollmentEnd() {
        fixtureConfiguration
                .given(new EnrollmentCreatedEvent(enrollmentId, title, description, configuration))
                .when(new EndEnrollmentCommand(enrollmentId))
                .expectEvents(new EnrollmentEndedEvent(enrollmentId));
    }

    @Test
    public void testEnrollmentAddMembershipRequest() {
        fixtureConfiguration
                .given(
                        new EnrollmentCreatedEvent(enrollmentId, title, description, configuration),
                        new EnrollmentStartedEvent(enrollmentId)
                )
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequestId))
                .expectEvents(new MembershipRequestAddedEvent(enrollmentId, membershipRequestId));
    }

    @Test
    public void testEnrollmentAddMembershipRequestWhenFull() {
        fixtureConfiguration
                .given(
                        new EnrollmentCreatedEvent(enrollmentId, title, description, configuration),
                        new EnrollmentStartedEvent(enrollmentId),
                        new MembershipRequestAddedEvent(enrollmentId, membershipRequestId2),
                        new MembershipRequestAddedEvent(enrollmentId, membershipRequestId3)
                )
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequestId))
                .expectEvents(new EnrollmentIsFullEvent(enrollmentId));
    }

    @Test
    public void testEnrollmentAddMembershipRequestWhenEnded() {
        fixtureConfiguration
                .given(
                        new EnrollmentCreatedEvent(enrollmentId, title, description, configuration),
                        new EnrollmentEndedEvent(enrollmentId)
                )
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequestId))
                .expectEvents(new EnrollmentIsNotStartedEvent(enrollmentId, EnrollmentStatus.ENDED));
    }

    @Test
    public void testEnrollmentAddMembershipRequestWhenCanceled() {
        fixtureConfiguration
                .given(
                        new EnrollmentCreatedEvent(enrollmentId, title, description, configuration),
                        new EnrollmentCanceledEvent(enrollmentId)
                )
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequestId))
                .expectEvents(new EnrollmentIsNotStartedEvent(enrollmentId, EnrollmentStatus.CANCELED));
    }

    @Test
    public void testEnrollmentAddMembershipRequestTwice() {
        fixtureConfiguration
                .given(
                        new EnrollmentCreatedEvent(enrollmentId, title, description, configuration),
                        new EnrollmentStartedEvent(enrollmentId),
                        new MembershipRequestAddedEvent(enrollmentId, membershipRequestId)
                )
                .when(new AddMembershipRequestCommand(enrollmentId, membershipRequestId))
                .expectEvents(new EnrollmentAlreadyContainsMembershipRequestEvent(enrollmentId, membershipRequestId));
    }
}
