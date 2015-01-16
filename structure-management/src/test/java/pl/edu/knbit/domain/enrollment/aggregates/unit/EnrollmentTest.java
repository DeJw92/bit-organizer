package pl.edu.knbit.domain.enrollment.aggregates.unit;

import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.enrollment.aggregates.Enrollment;
import pl.edu.knbit.domain.enrollment.aggregates.EnrollmentFactory;
import pl.edu.knbit.domain.enrollment.aggregates.exceptions.EnrollmentAlreadyContainsThisMembershipRequest;
import pl.edu.knbit.domain.enrollment.aggregates.exceptions.EnrollmentCantChangeStatus;
import pl.edu.knbit.domain.enrollment.aggregates.exceptions.EnrollmentIsFull;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentStatus;
import pl.edu.knbit.domain.enrollment.valueobjects.MembershipRequestId;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class EnrollmentTest {

    private final String TITLE = "Title";
    private final String DESC = "Desc";
    private final Integer REQUESTS_LIMIT = 3;

    private Enrollment enrollment;

    @Before
    public void setUp() {
        enrollment = EnrollmentFactory.create(new EnrollmentId(), TITLE, DESC, new EnrollmentConfiguration(REQUESTS_LIMIT));
    }

    @Test
    public void testEnrollmentCreation() {
        assertEquals(TITLE, enrollment.getTitle());
        assertEquals(DESC, enrollment.getDescription());
        assertEquals(EnrollmentStatus.CREATED, enrollment.getStatus());
        assertEquals(REQUESTS_LIMIT, enrollment.getConfiguration().getRequestsLimit());
        assertEquals(0, enrollment.getMembershipRequestIds().size());
    }

    @Test
    public void testStartEnrollment() {
        enrollment.startEnrollment();
        assertEquals(EnrollmentStatus.STARTED, enrollment.getStatus());
    }

    @Test
    public void testCancelEnrollment() {
        enrollment.startEnrollment();
        enrollment.cancelEnrollment();
        assertEquals(EnrollmentStatus.CANCELED, enrollment.getStatus());
    }

    @Test
    public void testEndEnrollment() {
        enrollment.startEnrollment();
        enrollment.endEnrollment();
        assertEquals(EnrollmentStatus.ENDED, enrollment.getStatus());
    }

    @Test(expected = EnrollmentCantChangeStatus.class)
    public void testEndCanceledEnrollment() {
        enrollment.startEnrollment();
        enrollment.cancelEnrollment();
        enrollment.endEnrollment();
    }

    @Test(expected = EnrollmentCantChangeStatus.class)
    public void testCancelEndedEnrollment() {
        enrollment.startEnrollment();
        enrollment.endEnrollment();
        enrollment.cancelEnrollment();
    }

    @Test(expected = EnrollmentCantChangeStatus.class)
    public void testEndNotStartedEnrollment() {
        enrollment.endEnrollment();
    }

    @Test(expected = EnrollmentCantChangeStatus.class)
    public void testCancelNotStartedEnrollment() {
        enrollment.cancelEnrollment();
    }

    @Test(expected = EnrollmentCantChangeStatus.class)
    public void testStartEnrollmentTwice() {
        enrollment.startEnrollment();
        enrollment.startEnrollment();
    }

    @Test
    public void testMembershipRequestAdding() {
        enrollment.startEnrollment();

        assertEquals(0, enrollment.getMembershipRequestIds().size());
        MembershipRequestId membershipRequestId = new MembershipRequestId(UUID.randomUUID());
        enrollment.addMembershipRequest(membershipRequestId);
        assertEquals(1, enrollment.getMembershipRequestIds().size());

        for (int i = 1; i < REQUESTS_LIMIT; ++i)
            enrollment.addMembershipRequest(new MembershipRequestId(UUID.randomUUID()));
        assertEquals(REQUESTS_LIMIT.intValue(), enrollment.getMembershipRequestIds().size());
    }

    @Test(expected = EnrollmentIsFull.class)
    public void testMembershipRequestAddingMoreThanLimit() {
        enrollment.startEnrollment();
        for (int i = 0; i <= REQUESTS_LIMIT; ++i)
            enrollment.addMembershipRequest(new MembershipRequestId(UUID.randomUUID()));
    }

    @Test(expected = EnrollmentAlreadyContainsThisMembershipRequest.class)
    public void testMembershipRequestAddingSameTwice() {
        enrollment.startEnrollment();

        assertEquals(0, enrollment.getMembershipRequestIds().size());
        MembershipRequestId membershipRequestId = new MembershipRequestId(UUID.randomUUID());
        enrollment.addMembershipRequest(membershipRequestId);
        assertEquals(1, enrollment.getMembershipRequestIds().size());
        enrollment.addMembershipRequest(membershipRequestId);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMembershipRequestGet() {
        MembershipRequestId membershipRequestId = new MembershipRequestId(UUID.randomUUID());
        enrollment.startEnrollment();
        enrollment.addMembershipRequest(membershipRequestId);
        enrollment.getMembershipRequestIds().remove(membershipRequestId);
    }
}
