package pl.edu.knbit.domain.aggregateRoots.project.commands;

import pl.edu.knbit.domain.aggregateRoots.project.entities.TeamMember;
import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

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
