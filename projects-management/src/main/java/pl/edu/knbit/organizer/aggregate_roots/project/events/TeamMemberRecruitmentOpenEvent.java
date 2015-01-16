package pl.edu.knbit.organizer.aggregate_roots.project.events;

import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberRecruitmentOpenEvent extends AbstractProjectEvent{
    public TeamMemberRecruitmentOpenEvent(ProjectID projectID) {
        super(projectID);
    }
}
