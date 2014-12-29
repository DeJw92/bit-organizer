package ddd.domain.commands;

import ddd.domain.entities.TeamMemberRecruitment;
import ddd.domain.value_objects.ProjectID;

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
