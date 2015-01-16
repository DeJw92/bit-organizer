package pl.edu.knbit.domain.idea.events;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class IdeaAbandonedEvent {
    private final IdeaId ideaId;

    public IdeaAbandonedEvent(IdeaId id) {
        this.ideaId = id;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }
}
