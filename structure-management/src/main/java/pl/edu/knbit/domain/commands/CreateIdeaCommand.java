package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.valueobjects.IdeaId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CreateIdeaCommand {
    @TargetAggregateIdentifier
    private final IdeaId ideaId;
    private final String title;
    private final String description;

    public CreateIdeaCommand(IdeaId ideaId, String title, String description) {
        this.ideaId = ideaId;
        this.title = title;
        this.description = description;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
