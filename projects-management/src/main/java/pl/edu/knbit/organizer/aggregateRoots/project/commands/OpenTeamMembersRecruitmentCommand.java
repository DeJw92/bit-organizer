package pl.edu.knbit.organizer.aggregateRoots.project.commands;

import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class OpenTeamMembersRecruitmentCommand extends AbstractProjectCommand {

    public OpenTeamMembersRecruitmentCommand(ProjectID projectID) {
        super(projectID);
    }
}
