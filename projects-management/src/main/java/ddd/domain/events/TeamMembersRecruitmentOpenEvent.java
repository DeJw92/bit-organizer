package ddd.domain.events;

import ddd.domain.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMembersRecruitmentOpenEvent extends AbstractProjectEvent{
    public TeamMembersRecruitmentOpenEvent(ProjectID projectID) {
        super(projectID);
    }
}
