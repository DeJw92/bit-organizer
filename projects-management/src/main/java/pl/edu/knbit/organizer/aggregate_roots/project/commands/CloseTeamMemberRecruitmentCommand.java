package pl.edu.knbit.organizer.aggregate_roots.project.commands;

import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class CloseTeamMemberRecruitmentCommand extends AbstractProjectCommand{
    public CloseTeamMemberRecruitmentCommand(ProjectID projectID) {
        super(projectID);
    }
}
