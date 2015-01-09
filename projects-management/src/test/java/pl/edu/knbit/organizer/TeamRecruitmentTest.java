package pl.edu.knbit.organizer;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.organizer.teamrecruitment.commands.ApplyForProjectCommand;
import pl.edu.knbit.organizer.teamrecruitment.events.MemberAppliedEvent;
import pl.edu.knbit.organizer.teamrecruitment.events.TeamRecruitmentOpenedEvent;
import pl.edu.knbit.organizer.teamrecruitment.MemberId;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitment;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentCommandHandler;
import pl.edu.knbit.organizer.teamrecruitment.TeamRecruitmentId;

public class TeamRecruitmentTest {

    private FixtureConfiguration<TeamRecruitment> fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(TeamRecruitment.class);

        final TeamRecruitmentCommandHandler commandHandler = new TeamRecruitmentCommandHandler();
        commandHandler.setRepository(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);
    }

    @Test
    public void testApplyForProject() {
        final TeamRecruitmentId teamRecruitmentId = TeamRecruitmentId.randomId();
        final MemberId memberId = new MemberId(1);
        fixture.given(new TeamRecruitmentOpenedEvent(teamRecruitmentId)).
                when(new ApplyForProjectCommand(teamRecruitmentId, memberId)).
                expectEvents(new MemberAppliedEvent(teamRecruitmentId, memberId));
    }
}