package pl.edu.knbit.domain.aggregateRoots.projectIdea.events;

import pl.edu.knbit.domain.aggregateRoots.projectIdea.valueObjects.ProjectIdeaID;

/**
 * Created by Eryk on 2015-01-12.
 */

public class TeamLeaderRecruitmentAlreadyOpenedEvent {

    private final ProjectIdeaID projectIdeaID;

    public TeamLeaderRecruitmentAlreadyOpenedEvent(ProjectIdeaID projectIdeaID) {
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID() {
        return projectIdeaID;
    }
}
