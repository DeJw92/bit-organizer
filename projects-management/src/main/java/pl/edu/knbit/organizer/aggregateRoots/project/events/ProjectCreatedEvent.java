package pl.edu.knbit.organizer.aggregateRoots.project.events;

import pl.edu.knbit.organizer.aggregateRoots.project.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

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
