package pl.edu.knbit.organizer.aggregate_roots.project_AR.commands;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMember;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class ResignFromTeamMemberCommand extends AbstractProjectCommand {
    private TeamMember teamMember;

    public ResignFromTeamMemberCommand(ProjectID projectID, TeamMember teamMember) {
        super(projectID);
        this.teamMember = teamMember;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }
}

