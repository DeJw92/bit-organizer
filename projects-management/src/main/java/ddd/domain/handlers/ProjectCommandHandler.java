package ddd.domain.handlers;

import ddd.domain.aggregate_roots.Project;
import ddd.domain.commands.AddTeamMemberCommand;
import ddd.domain.commands.CloseTeamMembersRecruitmentCommand;
import ddd.domain.commands.CreateProjectCommand;
import ddd.domain.commands.OpenTeamMembersRecruitmentCommand;
import ddd.domain.factories.ProjectFactory;
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
        project.addMember(addTeamMemberCommand.getMember());
    }

    public void setRepository(Repository<Project> repository) {
        this.repository = repository;
    }
}
