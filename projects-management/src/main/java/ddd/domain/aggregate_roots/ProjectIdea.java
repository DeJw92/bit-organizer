package ddd.domain.aggregate_roots;


import ddd.domain.entities.Member;
import ddd.domain.entities.TeamLeaderRecruitment;

import ddd.domain.events.*;
import ddd.domain.value_objects.ProjectIdeaID;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcedMember;

/**
 * Created by eric
 */

public class ProjectIdea extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private ProjectIdeaID projectIdeaID;

    @EventSourcedMember
    private TeamLeaderRecruitment teamLeaderRecruitment;

    private Member teamLeader;

    private String description;

    private ProjectIdea() {}

    public ProjectIdea(ProjectIdeaID projectIdeaID, TeamLeaderRecruitment teamLeaderRecruitment, String description){
        apply(new ProjectIdeaCreatedEvent(projectIdeaID, teamLeaderRecruitment, description));
    }

    @EventHandler
    public void onProjectIdeaCreated(ProjectIdeaCreatedEvent projectIdeaCreatedEvent){
        this.projectIdeaID = projectIdeaCreatedEvent.getProjectIdeaID();
        this.teamLeaderRecruitment = projectIdeaCreatedEvent.getTeamLeaderRecruitment();
    }

    @EventHandler
    public void onTeamLeaderAccepted(TeamLeaderAcceptedEvent teamLeaderAcceptedEvent) {
        this.teamLeader = teamLeaderAcceptedEvent.getLeader();
    }

    public void setProjectLeader(Member teamLeader) {
        apply(new TeamLeaderAcceptedEvent(teamLeader));
    }

    public void openTeamLeaderRecruitment() {
        apply(new TeamLeaderRecruitmentOpenedEvent(projectIdeaID));
    }

    public void closeTeamLeaderRecruitment() {
        apply(new TeamLeaderRecruitmentClosedEvent(projectIdeaID));
    }
}
