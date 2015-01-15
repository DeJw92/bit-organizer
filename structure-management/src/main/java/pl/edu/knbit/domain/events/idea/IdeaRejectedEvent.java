package pl.edu.knbit.domain.events.idea;

import pl.edu.knbit.domain.valueobjects.IdeaId;

public class IdeaRejectedEvent {
    private final IdeaId ideadId;

    public IdeaRejectedEvent(IdeaId ideaId) {
        this.ideadId = ideaId;
    }

    public IdeaId getIdeadId() {
        return ideadId;
    }
}
