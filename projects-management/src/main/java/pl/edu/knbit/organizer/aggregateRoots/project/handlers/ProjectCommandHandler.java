package pl.edu.knbit.organizer.aggregateRoots.project.handlers;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.knbit.organizer.aggregateRoots.project.Project;
import pl.edu.knbit.organizer.aggregateRoots.project.commands.*;
import pl.edu.knbit.organizer.aggregateRoots.project.factories.ProjectFactory;

/**
 * @author Pawel Kolodziejczyk, Dawid Pawlak
 */

@Component
public class ProjectCommandHandler {

    @Autowired
    private Repository<Project> projectRepository;

    @CommandHandler
    public void handleProjectCreatedCommand(CreateProjectCommand createProjectCommand) {
        final Project project = ProjectFactory.createProject(createProjectCommand.getProjectID(), createProjectCommand.getTeamMemberRecruitment());
        projectRepository.add(project);

    }

    @CommandHandler
    public void handleOpenTeamMembersRecruitmentCommand(OpenTeamMembersRecruitmentCommand openTeamMembersRecruitmentCommand) {
        final Project project = projectRepository.load(openTeamMembersRecruitmentCommand.getProjectID());
        project.openTeamMemberRecruitment();
    }

    @CommandHandler
    public void handleCloseTeamMembersRecruitmentCommand(CloseTeamMemberRecruitmentCommand closeTeamMemberRecruitmentCommand) {
        final Project project = projectRepository.load(closeTeamMemberRecruitmentCommand.getProjectID());
        project.closeTeamMemberRecruitment();
    }

    @CommandHandler
    public void handleAddTeamMemberCommand(AddTeamMemberCommand addTeamMemberCommand) {
        final Project project = projectRepository.load(addTeamMemberCommand.getProjectID());
        project.addMember(addTeamMemberCommand.getTeamMember());
    }

    @CommandHandler
    public void handleResignFromMemberCommand(ResignFromTeamMemberCommand resignFromMemberCommand) {
        final Project project = projectRepository.load(resignFromMemberCommand.getProjectID());
        project.resignFromMember(resignFromMemberCommand.getTeamMember());
    }

    @CommandHandler
    public void handleRemoveMemberCommand(RemoveTeamMemberCommand removeMemberCommand) {
        final Project project = projectRepository.load(removeMemberCommand.getProjectID());
        project.removeMember(removeMemberCommand.getTeamMember());
    }

    @CommandHandler
    public void handlePlaceProjectInStructureCommand(PlaceProjectInStructureCommand placeProjectInStructureCommand) {
        final Project project = projectRepository.load(placeProjectInStructureCommand.getProjectID());
        project.placeProjectInStructure();
    }

    public void setProjectRepository(Repository<Project> projectRepository) {
        this.projectRepository = projectRepository;
    }
}
