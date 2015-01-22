package pl.edu.knbit.organizer.aggregateRoots.project.commands;

import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class CloseTeamMemberRecruitmentCommand extends AbstractProjectCommand {
    public CloseTeamMemberRecruitmentCommand(ProjectID projectID) {
        super(projectID);
    }
}
