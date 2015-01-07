package pl.edu.knbit.organizer.aggregate_roots.project_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMembersRecruitmentOpenEvent extends AbstractProjectEvent{
    public TeamMembersRecruitmentOpenEvent(ProjectID projectID) {
        super(projectID);
    }
}
