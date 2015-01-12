package pl.edu.knbit.organizer.aggregate_roots.project_idea_AR;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.entities.MemberID;
import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.events.*;
import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.value_objects.ProjectIdeaID;
import pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.value_objects.TeamLeaderRecruitmentStatus;

/**
 * Created by eric
 */

public class ProjectIdea extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private ProjectIdeaID projectIdeaID;

    private TeamLeaderRecruitmentStatus status;

    private MemberID teamLeader;

    private String description;

    private ProjectIdea() {}

    public ProjectIdea(ProjectIdeaID projectIdeaID, String description){
        apply(new ProjectIdeaCreatedEvent(projectIdeaID, description));
    }

    @EventHandler
    public void onProjectIdeaCreated(ProjectIdeaCreatedEvent event){
        this.projectIdeaID = event.getProjectIdeaID();
    }

    @EventHandler
    public void onTeamLeaderAccepted(TeamLeaderAcceptedEvent event) {
        this.teamLeader = event.getLeader();
    }

    @EventHandler
    public void onTeamLeaderRecruitmentOpened(TeamLeaderRecruitmentOpenedEvent event){
        this.status = TeamLeaderRecruitmentStatus.OPEN;
    }

    public void setProjectLeader(MemberID teamLeader) {
        if(this.status == TeamLeaderRecruitmentStatus.OPEN){
            apply(new TeamLeaderAcceptedEvent(teamLeader));
        } else {
            apply(new TeamLeaderRecruitmentNotOpenedEvent(teamLeader));
        }

    }

    public void openTeamLeaderRecruitment() {
        if(this.status == TeamLeaderRecruitmentStatus.CLOSED ){
            apply(new TeamLeaderRecruitmentOpenedEvent(projectIdeaID));
        } else {
            apply(new TeamLeaderRecruitmentAlreadyOpenedEvent(projectIdeaID));
        }
    }
}
