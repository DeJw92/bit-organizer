package pl.edu.knbit.organizer.aggregate_roots.project_AR.handlers;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.Project;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.commands.*;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.factories.ProjectFactory;

/**
 * @author Pawel Kolodziejczyk, Dawid Pawlak
 */
public class ProjectCommandHandler {

    private Repository<Project> repository;

    @CommandHandler
    public void handleProjectCreatedCommand(CreateProjectCommand createProjectCommand) {
        final Project project = ProjectFactory.createProject(createProjectCommand.getProjectID(), createProjectCommand.getTeamMemberRecruitment());
        repository.add(project);

    }

    @CommandHandler
    public void handleOpenTeamMembersRecruitmentCommand(OpenTeamMembersRecruitmentCommand openTeamMembersRecruitmentCommand) {
        final Project project = repository.load(openTeamMembersRecruitmentCommand.getProjectID());
        project.openTeamMemberRecruitment();
    }

    @CommandHandler
    public void handleCloseTeamMembersRecruitmentCommand(CloseTeamMemberRecruitmentCommand closeTeamMemberRecruitmentCommand) {
        final Project project = repository.load(closeTeamMemberRecruitmentCommand.getProjectID());
        project.closeTeamMemberRecruitment();
    }

    @CommandHandler
    public void handleAddTeamMemberCommand(AddTeamMemberCommand addTeamMemberCommand) {
        final Project project = repository.load(addTeamMemberCommand.getProjectID());
        project.addMember(addTeamMemberCommand.getTeamMember());
    }

    @CommandHandler
    public void handleResignFromMemberCommand(ResignFromTeamMemberCommand resignFromMemberCommand) {
        final Project project = repository.load(resignFromMemberCommand.getProjectID());
        project.resignFromMember(resignFromMemberCommand.getTeamMember());
    }

    @CommandHandler
    public void handleRemoveMemberCommand(RemoveTeamMemberCommand removeMemberCommand) {
        final Project project = repository.load(removeMemberCommand.getProjectID());
        project.removeMember(removeMemberCommand.getTeamMember());
    }

    @CommandHandler
    public void handlePlaceProjectInStructureCommand(PlaceProjectInStructureCommand placeProjectInStructureCommand) {
        final Project project = repository.load(placeProjectInStructureCommand.getProjectID());
        project.placeProjectInStructure();
    }

    public void setRepository(Repository<Project> repository) {
        this.repository = repository;
    }
}
