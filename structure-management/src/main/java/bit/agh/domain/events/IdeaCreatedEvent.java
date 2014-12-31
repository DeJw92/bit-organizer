package bit.agh.domain.events;

import bit.agh.domain.valueobjects.IdeaId;

public class IdeaCreatedEvent {
    private final IdeaId ideaId;
    private final String title;
    private final String description;

    public IdeaCreatedEvent(IdeaId ideaId, String title, String description) {
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
