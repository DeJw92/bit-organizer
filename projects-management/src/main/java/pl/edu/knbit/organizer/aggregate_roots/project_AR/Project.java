package pl.edu.knbit.organizer.aggregate_roots.project_AR;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMember;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.TeamMemberRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.events.*;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcedMember;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dawid Pawlak.
 */
public class Project extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private ProjectID projectID;

    @EventSourcedMember
    private TeamMemberRecruitment teamMemberRecruitment;

    private Set<TeamMember> teamMembers = new HashSet<TeamMember>();


    private Project() {}

    public Project(ProjectID projectID, TeamMemberRecruitment teamMemberRecruitment) {
        apply(new ProjectCreatedEvent(projectID, teamMemberRecruitment));
    }


    public void openTeamMemberRecruitment() {
        apply(new TeamMemberRecruitmentOpenEvent(projectID));
    }

    public void closeTeamMemberRecruitment() {
        apply(new TeamMemberRecruitmentClosedEvent(projectID));
    }

    public void addMember(TeamMember teamMember) {
        if(!teamMemberRecruitment.isRecruitmentOpen()) {
            apply(new RecruitmentClosedEvent(projectID));
            return;
        }

        apply(new TeamMemberAddedEvent(projectID, teamMember));
    }

    @EventHandler
    public void onProjectCreated(ProjectCreatedEvent projectCreatedEvent) {
        this.projectID = projectCreatedEvent.getProjectID();
        this.teamMemberRecruitment = projectCreatedEvent.getTeamMemberRecruitment();
    }

    @EventHandler
    public void onTeamMemberAddedEvent(TeamMemberAddedEvent teamMemberAddedEvent) {
        teamMembers.add(teamMemberAddedEvent.getTeamMember());
    }



}
