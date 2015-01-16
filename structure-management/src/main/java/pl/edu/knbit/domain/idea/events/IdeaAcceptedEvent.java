package pl.edu.knbit.domain.idea.events;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class IdeaAcceptedEvent {
    private final IdeaId ideaId;

    public IdeaAcceptedEvent(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }
}
