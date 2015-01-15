package pl.edu.knbit.domain.aggregates.idea;

import pl.edu.knbit.domain.aggregates.idea.Idea;
import pl.edu.knbit.domain.valueobjects.IdeaId;

public class IdeaFactory {
    public static Idea create(IdeaId ideaId, String title, String description) {
        return new Idea(ideaId, title, description);
    }
}
