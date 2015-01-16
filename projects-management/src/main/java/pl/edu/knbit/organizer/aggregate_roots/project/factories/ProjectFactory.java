package pl.edu.knbit.organizer.aggregate_roots.project.factories;

import pl.edu.knbit.organizer.aggregate_roots.project.Project;
import pl.edu.knbit.organizer.aggregate_roots.project.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.project.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class ProjectFactory {
    public static Project createProject(ProjectID projectID, TeamMemberRecruitment teamMemberRecruitment) {
        return new Project(projectID, teamMemberRecruitment);
    }
}
