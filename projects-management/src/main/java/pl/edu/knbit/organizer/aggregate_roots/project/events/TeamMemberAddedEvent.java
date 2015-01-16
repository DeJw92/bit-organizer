package pl.edu.knbit.organizer.aggregate_roots.project.events;

import pl.edu.knbit.organizer.aggregate_roots.project.entities.TeamMember;
import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberAddedEvent extends AbstractProjectEvent{
    private final TeamMember teamMember;

    public TeamMemberAddedEvent(ProjectID projectID, TeamMember teamMember) {
        super(projectID);
        this.teamMember = teamMember;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }
}
