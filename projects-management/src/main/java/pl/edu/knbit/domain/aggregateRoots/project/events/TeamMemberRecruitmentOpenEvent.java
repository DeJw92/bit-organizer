package pl.edu.knbit.domain.aggregateRoots.project.events;

import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMemberRecruitmentOpenEvent extends AbstractProjectEvent {
    public TeamMemberRecruitmentOpenEvent(ProjectID projectID) {
        super(projectID);
    }
}
