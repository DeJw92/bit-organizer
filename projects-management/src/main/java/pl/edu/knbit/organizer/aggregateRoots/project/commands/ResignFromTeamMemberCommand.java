package pl.edu.knbit.organizer.aggregateRoots.project.commands;

import pl.edu.knbit.organizer.aggregateRoots.project.entities.TeamMember;
import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

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

