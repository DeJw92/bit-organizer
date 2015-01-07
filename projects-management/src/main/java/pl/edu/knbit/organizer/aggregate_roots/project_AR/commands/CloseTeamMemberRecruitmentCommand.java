package pl.edu.knbit.organizer.aggregate_roots.project_AR.commands;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class CloseTeamMemberRecruitmentCommand extends AbstractProjectCommand{
    public CloseTeamMemberRecruitmentCommand(ProjectID projectID) {
        super(projectID);
    }
}
