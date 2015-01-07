package ddd.domain.entities;

import ddd.domain.events.TeamMembersRecruitmentCloseEvent;
import ddd.domain.events.TeamMembersRecruitmentOpenEvent;
import ddd.domain.value_objects.TeamMemberRecruitmentStatus;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedEntity;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberRecruitment extends AbstractAnnotatedEntity {

    private TeamMemberRecruitmentStatus teamMemberRecruitmentStatus;

    public TeamMemberRecruitment(TeamMemberRecruitmentStatus teamMemberRecruitmentStatus) {
        this.teamMemberRecruitmentStatus = teamMemberRecruitmentStatus;
    }


    @EventHandler
    public void handleOpenTeamMemberRecruitmentEvent(TeamMembersRecruitmentOpenEvent teamMembersRecruitmentOpenEvent) {
        this.teamMemberRecruitmentStatus = TeamMemberRecruitmentStatus.OPEN;
    }

    @EventHandler
    public void handleCloseTeamMemberRecruitmentEvent(TeamMembersRecruitmentCloseEvent teamMembersRecruitmentCloseEvent) {
        this.teamMemberRecruitmentStatus = TeamMemberRecruitmentStatus.CLOSED;
    }

    public boolean isRecruitmentOpen() {
        return TeamMemberRecruitmentStatus.OPEN.equals(teamMemberRecruitmentStatus);
    }

}
