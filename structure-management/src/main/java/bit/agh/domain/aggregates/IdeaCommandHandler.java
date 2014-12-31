package bit.agh.domain.aggregates;

import bit.agh.domain.commands.CreateIdeaCommand;
import bit.agh.domain.commands.SelectParentGroupCommand;
import bit.agh.domain.valueobjects.GroupId;
import bit.agh.domain.valueobjects.IdeaId;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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

    @Autowired
    @Qualifier("ideaRepository")
    public void setIdeaRepository(Repository<Idea> ideaRepository) {
        this.ideaRepository = ideaRepository;
    }
}
