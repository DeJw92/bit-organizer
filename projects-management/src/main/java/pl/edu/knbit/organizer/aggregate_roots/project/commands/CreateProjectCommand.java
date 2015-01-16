package pl.edu.knbit.organizer.aggregate_roots.project.commands;

import pl.edu.knbit.organizer.aggregate_roots.project.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class CreateProjectCommand extends AbstractProjectCommand {

    private TeamMemberRecruitment teamMemberRecruitment;

    public CreateProjectCommand(ProjectID projectID, TeamMemberRecruitment teamMemberRecruitment) {
        super(projectID);
        this.teamMemberRecruitment = teamMemberRecruitment;
    }

    public TeamMemberRecruitment getTeamMemberRecruitment() {
        return teamMemberRecruitment;
    }
}
