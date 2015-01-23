package pl.edu.knbit.domain.aggregateRoots.project.commands;

import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class OpenTeamMembersRecruitmentCommand extends AbstractProjectCommand {

    public OpenTeamMembersRecruitmentCommand(ProjectID projectID) {
        super(projectID);
    }
}
