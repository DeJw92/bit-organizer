package pl.edu.knbit.organizer.aggregate_roots.project.events;

import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberRecruitmentClosedEvent extends AbstractProjectEvent {
    public TeamMemberRecruitmentClosedEvent(ProjectID projectID) {
        super(projectID);
    }
}
