package pl.edu.knbit.domain.idea.commands;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class AbandonIdeaCommand {
    private IdeaId ideaId;

    public AbandonIdeaCommand(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return this.ideaId;
    }
}
