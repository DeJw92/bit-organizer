package pl.edu.knbit.domain.aggregateRoots.project.commands;

import pl.edu.knbit.domain.aggregateRoots.project.entities.TeamMemberRecruitment;
import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

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
