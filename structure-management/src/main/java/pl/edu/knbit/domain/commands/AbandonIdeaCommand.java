package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.valueobjects.IdeaId;

public class AbandonIdeaCommand {
    private IdeaId ideaId;

    public AbandonIdeaCommand(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return this.ideaId;
    }
}
