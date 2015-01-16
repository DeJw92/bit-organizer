package pl.edu.knbit.domain.idea.commands;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class RejectIdeaCommand {
    private IdeaId ideaId;

    public RejectIdeaCommand(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return this.ideaId;
    }
}
