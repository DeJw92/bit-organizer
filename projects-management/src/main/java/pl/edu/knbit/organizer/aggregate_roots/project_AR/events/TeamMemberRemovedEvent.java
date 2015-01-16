package pl.edu.knbit.organizer.aggregate_roots.project_AR.events;


import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMember;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class TeamMemberRemovedEvent extends AbstractProjectEvent {
    public TeamMember getTeamMember() {
        return teamMember;
    }

    private final TeamMember teamMember;

    public TeamMemberRemovedEvent(ProjectID projectID, TeamMember teamMember) {
        super(projectID);
        this.teamMember = teamMember;
    }

}
