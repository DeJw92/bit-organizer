package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.TeamLeaderRecruitmentId;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.TeamLeaderRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.entities.Member;

import static org.junit.Assert.*;

/**
 * Created by Tomasz Chmielarz, Bartosz Zurkowski on 06.01.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class TeamLeaderRecruitmentTest {

    private TeamLeaderRecruitment recruitment;

    @Mock
    private Member candidate;

    @Before
    public void setUp() {
        recruitment = new TeamLeaderRecruitment(new TeamLeaderRecruitmentId(1));
    }

    @Test
    public void testApplyForTeamLeader() {
        recruitment.applyForTeamLeader(candidate);
        assertEquals(1, recruitment.getCandidates().size());
    }

    @Test
    public void testSelectTeamLeader() {
        recruitment.getCandidates().add(candidate);  // TODO: add vs applyForTeamLeder
        assertEquals(1, recruitment.getCandidates().size());
        recruitment.selectTeamLeader(candidate);
        assertEquals(0, recruitment.getCandidates().size());
    }
}
