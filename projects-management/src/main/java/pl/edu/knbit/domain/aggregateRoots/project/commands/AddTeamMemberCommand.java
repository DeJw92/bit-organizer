package pl.edu.knbit.domain.aggregateRoots.project.commands;

import pl.edu.knbit.domain.aggregateRoots.project.entities.TeamMember;
import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class AddTeamMemberCommand extends AbstractProjectCommand {

    private final TeamMember teamMember;

    public AddTeamMemberCommand(ProjectID projectID, TeamMember teamMember) {
        super(projectID);
        this.teamMember = teamMember;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }
}
