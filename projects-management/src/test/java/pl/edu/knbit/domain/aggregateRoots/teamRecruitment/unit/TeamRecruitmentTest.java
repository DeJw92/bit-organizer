package pl.edu.knbit.domain.aggregateRoots.teamRecruitment.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.aggregateRoots.teamRecruitment.TeamRecruitment;
import pl.edu.knbit.domain.aggregateRoots.teamRecruitment.valueObjects.MemberId;
import pl.edu.knbit.domain.aggregateRoots.teamRecruitment.valueObjects.TeamRecruitmentId;
import pl.edu.knbit.domain.aggregateRoots.teamRecruitment.valueObjects.TeamRecruitmentStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TeamRecruitmentTest {

    public TeamRecruitment teamRecruitment;

    @Before
    public void setUp() throws Exception {
        teamRecruitment = new TeamRecruitment(TeamRecruitmentId.randomId());
    }

    @Test
    public void closeShouldChangeStateToClosed() {
        // when
        teamRecruitment.closeRecruitment();

        // then
        Assert.assertEquals(TeamRecruitmentStatus.CLOSED, teamRecruitment.getStatus());
    }

    @Test
    public void finishShouldChangeStateToFinished() {
        // when
        teamRecruitment.finishRecruitment();

        // then
        assertEquals(TeamRecruitmentStatus.FINISHED, teamRecruitment.getStatus());
    }

    @Test
    public void applyShouldAddMemberToList() {
        // given
        final MemberId memberId = new MemberId(1);

        // when
        teamRecruitment.applyForProject(memberId);

        // then
        assertEquals(1, teamRecruitment.getAppliedMembers().size());
    }

    @Test
    public void acceptShouldRemoveMemberFromList() {
        // given
        final MemberId memberId = new MemberId(1);
        teamRecruitment.applyForProject(memberId);

        // when
        teamRecruitment.acceptMember(memberId);

        // then
        assertTrue(teamRecruitment.getAppliedMembers().isEmpty());
    }

    @Test
    public void rejectShouldRemoveMemberFromList() {
        // given
        final MemberId memberId = new MemberId(1);
        teamRecruitment.applyForProject(memberId);

        // when
        teamRecruitment.rejectMember(memberId);

        // then
        assertTrue(teamRecruitment.getAppliedMembers().isEmpty());
    }

}