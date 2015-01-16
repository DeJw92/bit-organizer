package pl.edu.knbit.organizer.aggregate_roots.project_AR.factories;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.Project;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class ProjectFactory {
    public static Project createProject(ProjectID projectID, TeamMemberRecruitment teamMemberRecruitment) {
        return new Project(projectID, teamMemberRecruitment);
    }
}
