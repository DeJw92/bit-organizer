package ddd.domain.handlers;


import ddd.domain.aggregate_roots.ProjectIdea;
import ddd.domain.commands.*;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;

/**
 * Created by eric on 1/1/15.
 */
public class ProjectIdeaCommandHandler {

    private Repository<ProjectIdea> repository;

    @CommandHandler
    public void handleProjectIdeaCreatedCommand(CreateProjectIdeaCommand command){
        ProjectIdea projectIdea = new ProjectIdea(command.getProjectIdeaID(),command.getTeamLeaderRecruitment());
        repository.add(projectIdea);
    }

    @CommandHandler
    public void handleAcceptTeamLeaderCommand(AcceptTeamLeaderCommand command){
        ProjectIdea projectIdea = repository.load(command.getProjectIdeaID());
        projectIdea.setProjectLeader(command.getLeader());
    }

    @CommandHandler
    public void handleOpenTeamLeaderRecruitmentCommand(OpenTeamLeaderRecruitmentCommand command){
        ProjectIdea projectIdea = repository.load(command.getProjectIdeaID());
        projectIdea.openTeamLeaderRecruitment();
    }

    @CommandHandler
    public void handleCloseTeamLeaderRecruitmentCommand(CloseTeamLeaderRecruitmentCommand command){
        ProjectIdea projectIdea = repository.load(command.getProjectIdeaID());
        projectIdea.closeTeamLeaderRecruitment();
    }

    @CommandHandler
    public void handleSelectIdeaCommand(SelectIdeaCommand command){

    }

}
