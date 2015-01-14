package pl.edu.knbit.organizer.aggregate_roots.project_AR;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcedMember;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import com.google.common.base.Preconditions;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMember;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.events.*;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dawid Pawlak, Pawel Kolodziejczyk
 */
public class Project extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private ProjectID projectID;

    @EventSourcedMember
    private TeamMemberRecruitment teamMemberRecruitment;

    private final Set<TeamMember> teamMembers = new HashSet<TeamMember>();

    private Project() {}

    public Project(ProjectID projectID, TeamMemberRecruitment teamMemberRecruitment) {
        apply(new ProjectCreatedEvent(projectID, teamMemberRecruitment));
    }


    public void openTeamMemberRecruitment() {
        if(!teamMemberRecruitment.isRecruitmentOpen()) {
            apply(new TeamMemberRecruitmentOpenEvent(projectID));
        }
    }

    public void closeTeamMemberRecruitment() {
        if(teamMemberRecruitment.isRecruitmentOpen()) {
            apply(new TeamMemberRecruitmentClosedEvent(projectID));
        }
    }

    public void addMember(TeamMember teamMember) {
        Preconditions.checkNotNull(teamMember);

        if(!teamMemberRecruitment.isRecruitmentOpen()) {
            apply(new RecruitmentClosedEvent(projectID));
            return;
        }
        if(!teamMembers.contains(teamMember)) {
            apply(new TeamMemberAddedEvent(projectID, teamMember));
        }
    }

    public void removeMember(TeamMember teamMember) {
        Preconditions.checkNotNull(teamMember);

        if(teamMembers.contains(teamMember)) {
            apply(new TeamMemberRemovedEvent(projectID, teamMember));
        }
    }

    public void resignFromMember(TeamMember teamMember) {
        Preconditions.checkNotNull(teamMember);

        if(teamMembers.contains(teamMember)) {
            apply(new TeamMemberRemovedEvent(projectID, teamMember));
        }
    }

    public void placeProjectInStructure() {
        apply(new ProjectPlacedInStructureEvent(projectID));
    }

    @EventSourcingHandler
    public void onProjectCreated(ProjectCreatedEvent projectCreatedEvent) {
        this.projectID = projectCreatedEvent.getProjectID();
        this.teamMemberRecruitment = projectCreatedEvent.getTeamMemberRecruitment();
    }

    @EventSourcingHandler
    public void onTeamMemberAddedEvent(TeamMemberAddedEvent teamMemberAddedEvent) {
        teamMembers.add(teamMemberAddedEvent.getTeamMember());
    }

    @EventSourcingHandler
    public void onMemberRemovedEvent(TeamMemberRemovedEvent teamMemberRemovedEvent) {
        teamMembers.remove(teamMemberRemovedEvent.getTeamMember());
    }
}
