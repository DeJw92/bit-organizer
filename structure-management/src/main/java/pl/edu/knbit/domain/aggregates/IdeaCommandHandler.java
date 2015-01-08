package pl.edu.knbit.domain.aggregates;

import pl.edu.knbit.domain.commands.CreateIdeaCommand;
import pl.edu.knbit.domain.commands.SelectGroupSupervisorCommand;
import pl.edu.knbit.domain.commands.SelectParentGroupCommand;
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
    public void handleCreateIdeaCommand(CreateIdeaCommand createIdeaCommand) {
        Idea idea = IdeaFactory.create(createIdeaCommand.getIdeaId(), createIdeaCommand.getTitle(), createIdeaCommand.getDescription());
        ideaRepository.add(idea);
    }
    @CommandHandler
    public void handleSelectParentGroupCommand(SelectParentGroupCommand selectParentGroupCommand) {
        GroupId groupId = selectParentGroupCommand.getGroupId();
        IdeaId ideaId = selectParentGroupCommand.getIdeaId();
        Idea idea = ideaRepository.load(ideaId);
        idea.selectParentGroup(groupId);
    }

    @CommandHandler
    public void handleSelectGroupSupervisorCommand(SelectGroupSupervisorCommand selectGroupSupervisorCommand) throws ParentGroupNotSelectedException {
        GroupId groupId = selectGroupSupervisorCommand.getGroupId();
        IdeaId ideaId = selectGroupSupervisorCommand.getIdeaId();
        UserId groupSupervisorId = selectGroupSupervisorCommand.getGroupSupervisorId();
        Idea idea = ideaRepository.load(ideaId);
        idea.selectGroupSupervisor(groupSupervisorId);
    }

    @Autowired
    @Qualifier("ideaRepository")
    public void setIdeaRepository(Repository<Idea> ideaRepository) {
        this.ideaRepository = ideaRepository;
    }
}
