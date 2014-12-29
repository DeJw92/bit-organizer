package ddd.domain.events;

import ddd.domain.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class RecruitmentClosedEvent extends AbstractProjectEvent{
    public RecruitmentClosedEvent(ProjectID projectID) {
        super(projectID);
    }
}
