package pl.edu.knbit.organizer.aggregate_roots.project.commands;

import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class OpenTeamMembersRecruitmentCommand extends AbstractProjectCommand {

    public OpenTeamMembersRecruitmentCommand(ProjectID projectID) {
        super(projectID);
    }
}
