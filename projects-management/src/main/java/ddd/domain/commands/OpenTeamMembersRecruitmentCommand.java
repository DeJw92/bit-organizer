package ddd.domain.commands;

import ddd.domain.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class OpenTeamMembersRecruitmentCommand extends AbstractProjectCommand {

    public OpenTeamMembersRecruitmentCommand(ProjectID projectID) {
        super(projectID);
    }
}
