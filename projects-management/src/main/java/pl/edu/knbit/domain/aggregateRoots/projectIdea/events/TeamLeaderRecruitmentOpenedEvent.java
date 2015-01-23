package pl.edu.knbit.domain.aggregateRoots.projectIdea.events;


import pl.edu.knbit.domain.aggregateRoots.projectIdea.valueObjects.ProjectIdeaID;

/**
 * Created by eric on 12/31/14.
 */
public class TeamLeaderRecruitmentOpenedEvent {

    private final ProjectIdeaID projectIdeaID;

    public TeamLeaderRecruitmentOpenedEvent(ProjectIdeaID projectIdeaID) {
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID() {
        return projectIdeaID;
    }

}
