package pl.edu.knbit.organizer.aggregate_roots.project_AR.handlers;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.Project;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.commands.AddTeamMemberCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.commands.CloseTeamMembersRecruitmentCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.commands.CreateProjectCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.commands.OpenTeamMembersRecruitmentCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.factories.ProjectFactory;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;

/**
 * Created by Dawid Pawlak.
 */
public class ProjectCommandHandler {

    private Repository<Project> repository;

    @CommandHandler
    public void handleProjectCreatedCommand(CreateProjectCommand createProjectCommand) {
        Project project = ProjectFactory.createProject(createProjectCommand.getProjectID(), createProjectCommand.getTeamMemberRecruitment());
        repository.add(project);

    }

    @CommandHandler
    public void handleOpenTeamMembersRecruitmentCommand(OpenTeamMembersRecruitmentCommand openTeamMembersRecruitmentCommand) {
        Project project = repository.load(openTeamMembersRecruitmentCommand.getProjectID());
        project.openTeamMemberRecruitment();
    }

    @CommandHandler
    public void handleCloseTeamMembersRecruitmentCommand(CloseTeamMembersRecruitmentCommand closeTeamMembersRecruitmentCommand) {
        Project project = repository.load(closeTeamMembersRecruitmentCommand.getProjectID());
        project.closeTeamMemberRecruitment();
    }

    @CommandHandler
    public void handleAddTeamMemberCommand(AddTeamMemberCommand addTeamMemberCommand) {
        Project project = repository.load(addTeamMemberCommand.getProjectID());
        project.addMember(addTeamMemberCommand.getTeamMember());
    }

    public void setRepository(Repository<Project> repository) {
        this.repository = repository;
    }
}
