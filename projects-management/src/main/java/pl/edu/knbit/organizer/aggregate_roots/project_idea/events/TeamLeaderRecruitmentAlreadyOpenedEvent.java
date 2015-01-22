package pl.edu.knbit.organizer.aggregate_roots.project_idea.events;

import pl.edu.knbit.organizer.aggregate_roots.project_idea.value_objects.ProjectIdeaID;

/**
 * Created by Eryk on 2015-01-12.
 */

public class TeamLeaderRecruitmentAlreadyOpenedEvent {

    private final ProjectIdeaID projectIdeaID;

    public TeamLeaderRecruitmentAlreadyOpenedEvent(ProjectIdeaID projectIdeaID) {
        this.projectIdeaID = projectIdeaID;
    }

    public ProjectIdeaID getProjectIdeaID(){
        return projectIdeaID;
    }
}
