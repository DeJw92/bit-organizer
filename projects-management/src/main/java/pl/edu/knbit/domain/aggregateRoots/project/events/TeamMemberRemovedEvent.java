package pl.edu.knbit.domain.aggregateRoots.project.events;


import pl.edu.knbit.domain.aggregateRoots.project.entities.TeamMember;
import pl.edu.knbit.domain.aggregateRoots.project.valueObjects.ProjectID;

/**
 * @author Pawel Kolodziejczyk
 */
public class TeamMemberRemovedEvent extends AbstractProjectEvent {
    public TeamMember getTeamMember() {
        return teamMember;
    }

    private final TeamMember teamMember;

    public TeamMemberRemovedEvent(ProjectID projectID, TeamMember teamMember) {
        super(projectID);
        this.teamMember = teamMember;
    }

}
