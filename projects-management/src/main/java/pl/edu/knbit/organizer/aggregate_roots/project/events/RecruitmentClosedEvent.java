package pl.edu.knbit.organizer.aggregate_roots.project.events;

import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class RecruitmentClosedEvent extends AbstractProjectEvent{
    public RecruitmentClosedEvent(ProjectID projectID) {
        super(projectID);
    }
}
