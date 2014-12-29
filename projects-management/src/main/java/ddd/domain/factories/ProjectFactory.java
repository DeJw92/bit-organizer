package ddd.domain.factories;

import ddd.domain.aggregate_roots.Project;
import ddd.domain.entities.TeamMemberRecruitment;
import ddd.domain.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class ProjectFactory {
    public static Project createProject(ProjectID projectID, TeamMemberRecruitment teamMemberRecruitment) {
        return new Project(projectID, teamMemberRecruitment);
    }
}
