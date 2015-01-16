package pl.edu.knbit.organizer.aggregate_roots.project_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberRecruitmentOpenEvent extends AbstractProjectEvent{
    public TeamMemberRecruitmentOpenEvent(ProjectID projectID) {
        super(projectID);
    }
}
