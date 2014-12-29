package ddd.domain.events;

import ddd.domain.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMembersRecruitmentCloseEvent extends AbstractProjectEvent {
    public TeamMembersRecruitmentCloseEvent(ProjectID projectID) {
        super(projectID);
    }
}
