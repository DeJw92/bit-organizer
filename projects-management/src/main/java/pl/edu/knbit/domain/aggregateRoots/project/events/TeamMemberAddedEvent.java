package pl.edu.knbit.domain.aggregateRoots.project.events;

import pl.edu.knbit.domain.aggregateRoots.project.entities.TeamMember;
import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberAddedEvent extends AbstractProjectEvent {
    private final TeamMember teamMember;

    public TeamMemberAddedEvent(ProjectID projectID, TeamMember teamMember) {
        super(projectID);
        this.teamMember = teamMember;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }
}
