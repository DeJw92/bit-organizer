package pl.edu.knbit.domain.idea.exceptions;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class ParentGroupNotSelectedException extends Exception {
    private final IdeaId ideaId;

    public ParentGroupNotSelectedException(IdeaId ideaId) {
        this.ideaId = ideaId;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }
}
