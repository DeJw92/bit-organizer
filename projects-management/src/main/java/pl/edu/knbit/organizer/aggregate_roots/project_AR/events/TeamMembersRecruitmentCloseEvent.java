package pl.edu.knbit.organizer.aggregate_roots.project_AR.events;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMembersRecruitmentCloseEvent extends AbstractProjectEvent {
    public TeamMembersRecruitmentCloseEvent(ProjectID projectID) {
        super(projectID);
    }
}
