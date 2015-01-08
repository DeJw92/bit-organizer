package pl.edu.knbit.domain.exceptions;

import pl.edu.knbit.domain.valueobjects.IdeaId;

public class IdeaAlreadyAcceptedException extends Throwable {
    private final IdeaId ideaId;

    public IdeaAlreadyAcceptedException(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }
}
