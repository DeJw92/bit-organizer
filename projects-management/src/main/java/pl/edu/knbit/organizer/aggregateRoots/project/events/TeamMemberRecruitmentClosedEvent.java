package pl.edu.knbit.organizer.aggregateRoots.project.events;

import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberRecruitmentClosedEvent extends AbstractProjectEvent {
    public TeamMemberRecruitmentClosedEvent(ProjectID projectID) {
        super(projectID);
    }
}
