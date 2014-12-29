package ddd.domain.commands;

import ddd.domain.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class CloseTeamMembersRecruitmentCommand extends AbstractProjectCommand{
    public CloseTeamMembersRecruitmentCommand(ProjectID projectID) {
        super(projectID);
    }
}
