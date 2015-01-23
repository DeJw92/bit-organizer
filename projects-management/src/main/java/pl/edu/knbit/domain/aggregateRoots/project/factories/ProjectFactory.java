package pl.edu.knbit.domain.aggregateRoots.project.factories;

import pl.edu.knbit.domain.aggregateRoots.project.Project;
import pl.edu.knbit.domain.aggregateRoots.project.entities.TeamMemberRecruitment;
import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class ProjectFactory {
    public static Project createProject(ProjectID projectID, TeamMemberRecruitment teamMemberRecruitment) {
        return new Project(projectID, teamMemberRecruitment);
    }
}
