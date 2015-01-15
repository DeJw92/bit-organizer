package pl.edu.knbit.domain.commands.idea;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import pl.edu.knbit.domain.valueobjects.IdeaId;

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
