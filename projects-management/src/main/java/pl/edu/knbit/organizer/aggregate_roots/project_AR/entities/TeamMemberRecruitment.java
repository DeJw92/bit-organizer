package pl.edu.knbit.organizer.aggregate_roots.project_AR.entities;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.events.TeamMembersRecruitmentCloseEvent;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.events.TeamMembersRecruitmentOpenEvent;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.TeamMemberRecruitmentStatus;
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
