package pl.edu.knbit.domain.idea.events;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class IdeaRejectedEvent {
    private final IdeaId ideadId;

    public IdeaRejectedEvent(IdeaId ideaId) {
        this.ideadId = ideaId;
    }

    public IdeaId getIdeadId() {
        return ideadId;
    }
}
