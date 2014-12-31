package bit.agh.domain.aggregates;

import bit.agh.domain.valueobjects.IdeaId;

public class IdeaFactory {
    public static Idea create(IdeaId ideaId, String title, String description) {
        return new Idea(ideaId, title, description);
    }
}
