package pl.edu.knbit.organizer.aggregate_roots.project.entities;

import pl.edu.knbit.organizer.aggregate_roots.project.events.TeamMemberRecruitmentClosedEvent;
import pl.edu.knbit.organizer.aggregate_roots.project.events.TeamMemberRecruitmentOpenEvent;
import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.TeamMemberRecruitmentStatus;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedEntity;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberRecruitment extends AbstractAnnotatedEntity {

    private TeamMemberRecruitmentStatus teamMemberRecruitmentStatus = TeamMemberRecruitmentStatus.CLOSED;

    public TeamMemberRecruitment() {
    }


    @EventHandler
    public void handleOpenTeamMemberRecruitmentEvent(TeamMemberRecruitmentOpenEvent teamMemberRecruitmentOpenEvent) {
        this.teamMemberRecruitmentStatus = TeamMemberRecruitmentStatus.OPEN;
    }

    @EventHandler
    public void handleCloseTeamMemberRecruitmentEvent(TeamMemberRecruitmentClosedEvent teamMemberRecruitmentClosedEvent) {
        this.teamMemberRecruitmentStatus = TeamMemberRecruitmentStatus.CLOSED;
    }

    public boolean isRecruitmentOpen() {
        return TeamMemberRecruitmentStatus.OPEN.equals(teamMemberRecruitmentStatus);
    }

}