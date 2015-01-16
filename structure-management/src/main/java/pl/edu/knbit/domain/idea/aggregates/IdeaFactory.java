package pl.edu.knbit.domain.idea.aggregates;

import pl.edu.knbit.domain.idea.valueobjects.IdeaId;

public class IdeaFactory {
    public static Idea create(IdeaId ideaId, String title, String description) {
        return new Idea(ideaId, title, description);
    }
}
