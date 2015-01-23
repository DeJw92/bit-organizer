package pl.edu.knbit.domain.aggregateRoots.project.events;

import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class RecruitmentClosedEvent extends AbstractProjectEvent {
    public RecruitmentClosedEvent(ProjectID projectID) {
        super(projectID);
    }
}
