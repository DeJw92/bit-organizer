package pl.edu.knbit.domain.idea.commands;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class SubmitIdeaCommand {
    @TargetAggregateIdentifier
    private final IdeaId ideaId;
    private final String title;
    private final String description;

    public SubmitIdeaCommand(IdeaId ideaId, String title, String description) {
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
