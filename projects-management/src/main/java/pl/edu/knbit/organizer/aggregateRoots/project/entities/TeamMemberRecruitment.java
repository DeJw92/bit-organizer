package pl.edu.knbit.organizer.aggregateRoots.project.entities;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedEntity;
import pl.edu.knbit.organizer.aggregateRoots.project.events.TeamMemberRecruitmentClosedEvent;
import pl.edu.knbit.organizer.aggregateRoots.project.events.TeamMemberRecruitmentOpenEvent;
import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.TeamMemberRecruitmentStatus;

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
