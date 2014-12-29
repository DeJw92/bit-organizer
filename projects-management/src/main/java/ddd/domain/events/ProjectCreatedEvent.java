package ddd.domain.events;

import ddd.domain.entities.TeamMemberRecruitment;
import ddd.domain.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class ProjectCreatedEvent extends AbstractProjectEvent {

    private TeamMemberRecruitment teamMemberRecruitment;

    public ProjectCreatedEvent(ProjectID projectID, TeamMemberRecruitment teamMemberRecruitment) {
        super(projectID);
        this.teamMemberRecruitment = teamMemberRecruitment;
    }

    public TeamMemberRecruitment getTeamMemberRecruitment() {
        return teamMemberRecruitment;
    }
}
