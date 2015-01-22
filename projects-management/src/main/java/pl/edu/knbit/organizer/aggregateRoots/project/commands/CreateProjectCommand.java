package pl.edu.knbit.organizer.aggregateRoots.project.commands;

import pl.edu.knbit.organizer.aggregateRoots.project.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

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
