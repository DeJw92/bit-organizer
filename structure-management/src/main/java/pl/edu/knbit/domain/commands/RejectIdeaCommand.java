package pl.edu.knbit.domain.commands;

import pl.edu.knbit.domain.valueobjects.IdeaId;

public class RejectIdeaCommand {
    private IdeaId ideaId;

    public RejectIdeaCommand(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return this.ideaId;
    }
}
