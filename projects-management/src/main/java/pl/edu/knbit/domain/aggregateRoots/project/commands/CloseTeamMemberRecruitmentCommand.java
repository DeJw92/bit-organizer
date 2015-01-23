package pl.edu.knbit.domain.aggregateRoots.project.commands;

import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class CloseTeamMemberRecruitmentCommand extends AbstractProjectCommand {
    public CloseTeamMemberRecruitmentCommand(ProjectID projectID) {
        super(projectID);
    }
}
