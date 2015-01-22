package pl.edu.knbit.organizer.aggregateRoots.project.events;

import pl.edu.knbit.organizer.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberRecruitmentOpenEvent extends AbstractProjectEvent {
    public TeamMemberRecruitmentOpenEvent(ProjectID projectID) {
        super(projectID);
    }
}
