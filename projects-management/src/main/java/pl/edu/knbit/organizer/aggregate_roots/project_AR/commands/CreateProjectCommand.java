package pl.edu.knbit.organizer.aggregate_roots.project_AR.commands;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

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
