package pl.edu.knbit.domain.exceptions;

import pl.edu.knbit.domain.valueobjects.IdeaId;

public class ParentGroupNotSelectedException extends Exception {
    private final IdeaId ideaId;

    public ParentGroupNotSelectedException(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }
}
