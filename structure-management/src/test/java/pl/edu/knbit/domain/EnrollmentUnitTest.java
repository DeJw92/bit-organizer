package pl.edu.knbit.domain;

import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.aggregates.enrollment.Enrollment;
import pl.edu.knbit.domain.aggregates.enrollment.EnrollmentFactory;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentConfiguration;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentStatus;
import pl.edu.knbit.domain.valueobjects.MembershipRequestId;

import java.util.UUID;

import static org.junit.Assert.*;

public class EnrollmentUnitTest {

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
        enrollment.cancelEnrollment();
        assertEquals(EnrollmentStatus.CANCELED, enrollment.getStatus());
    }

    @Test
    public void testEndEnrollment() {
        enrollment.endEnrollment();
        assertEquals(EnrollmentStatus.ENDED, enrollment.getStatus());
    }

    @Test
    public void testMembershipRequestAdding() {
        assertEquals(0, enrollment.getMembershipRequestIds().size());
        enrollment.addMembershipRequest(new MembershipRequestId(UUID.randomUUID()));

        enrollment.startEnrollment();

        assertEquals(0, enrollment.getMembershipRequestIds().size());
        MembershipRequestId membershipRequestId = new MembershipRequestId(UUID.randomUUID());
        enrollment.addMembershipRequest(membershipRequestId);
        assertEquals(1, enrollment.getMembershipRequestIds().size());
        enrollment.addMembershipRequest(membershipRequestId);
        assertEquals(1, enrollment.getMembershipRequestIds().size());

        for (int i = 1; i < REQUESTS_LIMIT; ++i)
            enrollment.addMembershipRequest(new MembershipRequestId(UUID.randomUUID()));
        assertEquals(REQUESTS_LIMIT.intValue(), enrollment.getMembershipRequestIds().size());

        enrollment.addMembershipRequest(new MembershipRequestId(UUID.randomUUID()));
        assertEquals(REQUESTS_LIMIT.intValue(), enrollment.getMembershipRequestIds().size());
    }
}
