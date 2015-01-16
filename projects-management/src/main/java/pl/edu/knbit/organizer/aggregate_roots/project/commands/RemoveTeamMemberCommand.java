package pl.edu.knbit.organizer.aggregate_roots.project.commands;

import pl.edu.knbit.organizer.aggregate_roots.project.entities.TeamMember;
import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class RemoveTeamMemberCommand extends AbstractProjectCommand {
    private TeamMember teamMember;

    public RemoveTeamMemberCommand(ProjectID projectID, TeamMember teamMember) {
        super(projectID);
        this.teamMember = teamMember;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }
}
