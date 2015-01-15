package pl.edu.knbit.domain.commands.handlers;

import pl.edu.knbit.domain.aggregates.idea.Idea;
import pl.edu.knbit.domain.aggregates.idea.IdeaFactory;
import pl.edu.knbit.domain.commands.idea.*;
import pl.edu.knbit.domain.exceptions.ParentGroupNotSelectedException;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.knbit.domain.valueobjects.UserId;

@Component
public class IdeaCommandHandler {
    private Repository<Idea> ideaRepository;

    @CommandHandler
    public void handleSubmitIdeaCommand(SubmitIdeaCommand submitIdeaCommand) {
        Idea idea = IdeaFactory.create(submitIdeaCommand.getIdeaId(), submitIdeaCommand.getTitle(), submitIdeaCommand.getDescription());
        ideaRepository.add(idea);
    }
    @CommandHandler
    public void handleSelectParentGroupCommand(SelectParentGroupCommand selectParentGroupCommand) {
        GroupId groupId = selectParentGroupCommand.getGroupId();
        //TODO check if exists?
        IdeaId ideaId = selectParentGroupCommand.getIdeaId();
        //TODO check if exists?
        Idea idea = ideaRepository.load(ideaId);
        idea.selectParentGroup(groupId);
    }

    @CommandHandler
    public void handleSelectGroupSupervisorCommand(SelectGroupSupervisorCommand selectGroupSupervisorCommand) throws ParentGroupNotSelectedException {
        GroupId groupId = selectGroupSupervisorCommand.getGroupId();
        //TODO check if exists?
        IdeaId ideaId = selectGroupSupervisorCommand.getIdeaId();
        //TODO check if exists?
        UserId groupSupervisorId = selectGroupSupervisorCommand.getGroupSupervisorId();
        //TODO check if exists?
        Idea idea = ideaRepository.load(ideaId);
        GroupId parentGroupId = idea.getParentGroupId();
        if(parentGroupId == null) {
            throw new ParentGroupNotSelectedException(ideaId);
        }
        //TODO check if potential supervisor belongs to parent group
        idea.selectGroupSupervisor(groupSupervisorId);
    }

    @CommandHandler
    public void handleAcceptIdeaCommand(AcceptIdeaCommand acceptIdeaCommand) throws IllegalStateException {
        IdeaId ideaId = acceptIdeaCommand.getIdeaId();
        //TODO check if exists?
        Idea idea = ideaRepository.load(ideaId);
        idea.accept();
    }

    @CommandHandler
    public void handleRejectIdeaCommand(RejectIdeaCommand rejectIdeaCommand) throws IllegalStateException {
        IdeaId ideaId = rejectIdeaCommand.getIdeaId();
        //TODO check if exists?
        Idea idea = ideaRepository.load(ideaId);
        idea.reject();
    }

    @CommandHandler
    public void handleAbandonIdeaCommand(AbandonIdeaCommand abandonIdeaCommand) throws IllegalStateException {
        IdeaId ideaId = abandonIdeaCommand.getIdeaId();
        //TODO check if exists?
        Idea idea = ideaRepository.load(ideaId);
        idea.abandon();
    }

    @Autowired
    @Qualifier("ideaRepository")
    public void setIdeaRepository(Repository<Idea> ideaRepository) {
        this.ideaRepository = ideaRepository;
    }
}
