package pl.edu.knbit.organizer.aggregateRoots.projectIdea.handlers;


import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.ProjectIdea;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.commands.AcceptTeamLeaderCommand;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.commands.CreateProjectIdeaCommand;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.commands.OpenTeamLeaderRecruitmentCommand;
import pl.edu.knbit.organizer.aggregateRoots.projectIdea.commands.SelectIdeaCommand;

/**
 * Created by eric
 */

@Component
public class ProjectIdeaCommandHandler {

    @Autowired
    private Repository<ProjectIdea> projectIdeaRepository;

    @CommandHandler
    public void handleProjectIdeaCreatedCommand(CreateProjectIdeaCommand command) {
        ProjectIdea projectIdea = new ProjectIdea(command.getProjectIdeaID(), command.getDescription());
        projectIdeaRepository.add(projectIdea);
    }

    @CommandHandler
    public void handleAcceptTeamLeaderCommand(AcceptTeamLeaderCommand command) {
        ProjectIdea projectIdea = projectIdeaRepository.load(command.getProjectIdeaID());
        projectIdea.setProjectLeader(command.getLeader());
    }

    @CommandHandler
    public void handleOpenTeamLeaderRecruitmentCommand(OpenTeamLeaderRecruitmentCommand command) {
        ProjectIdea projectIdea = projectIdeaRepository.load(command.getProjectIdeaID());
        projectIdea.openTeamLeaderRecruitment();
    }

    @CommandHandler
    public void handleSelectIdeaCommand(SelectIdeaCommand command) {

    }

    public void setProjectIdeaRepository(Repository<ProjectIdea> repository) {
        this.projectIdeaRepository = repository;
    }

}
