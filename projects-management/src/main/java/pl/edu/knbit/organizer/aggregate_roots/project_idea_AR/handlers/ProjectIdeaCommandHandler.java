package pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.handlers;


import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.ProjectIdea;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.commands.AcceptTeamLeaderCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.commands.CreateProjectIdeaCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.commands.OpenTeamLeaderRecruitmentCommand;
import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.commands.SelectIdeaCommand;

/**
 * Created by eric
 */

public class ProjectIdeaCommandHandler{

    private Repository<ProjectIdea> repository;

    @CommandHandler
    public void handleProjectIdeaCreatedCommand(CreateProjectIdeaCommand command){
        ProjectIdea projectIdea = new ProjectIdea(command.getProjectIdeaID(),command.getDescription());
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
    public void handleSelectIdeaCommand(SelectIdeaCommand command){

    }

}
