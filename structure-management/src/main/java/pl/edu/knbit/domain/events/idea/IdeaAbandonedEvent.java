package pl.edu.knbit.domain.events.idea;

import pl.edu.knbit.domain.valueobjects.IdeaId;

public class IdeaAbandonedEvent {
    private final IdeaId ideaId;

    public IdeaAbandonedEvent(IdeaId id) {
        this.ideaId = id;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }
}
