package pl.edu.knbit.organizer.aggregate_roots.project.commands;

import pl.edu.knbit.organizer.aggregate_roots.project.entities.TeamMember;
import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class AddTeamMemberCommand extends AbstractProjectCommand{

    private final TeamMember teamMember;

    public AddTeamMemberCommand(ProjectID projectID, TeamMember teamMember) {
        super(projectID);
        this.teamMember = teamMember;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }
}
