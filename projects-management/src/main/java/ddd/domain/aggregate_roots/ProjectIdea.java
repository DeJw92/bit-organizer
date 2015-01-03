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

    private ProjectIdea() {}

    public ProjectIdea(ProjectIdeaID projectIdeaID, TeamLeaderRecruitment teamLeaderRecruitment){
        apply(new ProjectIdeaCreatedEvent(projectIdeaID, teamLeaderRecruitment));
    }

    @EventHandler
    public void onProjectIdeaCreated(ProjectIdeaCreatedEvent projectIdeaCreatedEvent){
        this.projectIdeaID = projectIdeaCreatedEvent.getProjectIdeaID();
        this.teamLeaderRecruitment = projectIdeaCreatedEvent.getTeamLeaderRecruitment();
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
