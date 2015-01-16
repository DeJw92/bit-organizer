package pl.edu.knbit.domain.idea.exceptions;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class IdeaAlreadyAcceptedException extends Throwable {
    private final IdeaId ideaId;

    public IdeaAlreadyAcceptedException(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }
}
