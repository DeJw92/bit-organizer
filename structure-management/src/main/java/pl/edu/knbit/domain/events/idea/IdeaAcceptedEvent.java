package pl.edu.knbit.domain.events.idea;

import pl.edu.knbit.domain.valueobjects.IdeaId;

public class IdeaAcceptedEvent {
    private final IdeaId ideaId;

    public IdeaAcceptedEvent(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }
}
