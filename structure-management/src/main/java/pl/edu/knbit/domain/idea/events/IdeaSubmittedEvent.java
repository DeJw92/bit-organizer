package pl.edu.knbit.domain.idea.events;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class IdeaSubmittedEvent {
    private final IdeaId ideaId;
    private final String title;
    private final String description;

    public IdeaSubmittedEvent(IdeaId ideaId, String title, String description) {
        this.ideaId = ideaId;
        this.title = title;
        this.description = description;
    }

    public IdeaId getIdeaId() {
        return ideaId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
