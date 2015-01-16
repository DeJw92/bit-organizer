package pl.edu.knbit.domain.idea.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class AcceptIdeaCommand {
    @TargetAggregateIdentifier
    private final IdeaId ideaId;

    public AcceptIdeaCommand(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }
}
