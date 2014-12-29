package ddd.domain.aggregate_roots;

import ddd.domain.entities.Member;
import ddd.domain.entities.TeamMemberRecruitment;
import ddd.domain.events.*;
import ddd.domain.value_objects.ProjectID;
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

    private Set<Member> members = new HashSet<Member>();


    private Project() {}

    public Project(ProjectID projectID, TeamMemberRecruitment teamMemberRecruitment) {
        apply(new ProjectCreatedEvent(projectID, teamMemberRecruitment));
    }


    public void openTeamMemberRecruitment() {
        apply(new TeamMembersRecruitmentOpenEvent(projectID));
    }

    public void closeTeamMemberRecruitment() {
        apply(new TeamMembersRecruitmentCloseEvent(projectID));
    }

    public void addMember(Member member) {
        if(!teamMemberRecruitment.isRecruitmentOpen()) {
            apply(new RecruitmentClosedEvent(projectID));
            return;
        }
        if(!teamMemberRecruitment.acceptMember(member)) {
            apply(new MemberRejectedEvent(projectID, member));
            return;
        }

        apply(new TeamMemberAddedEvent(projectID, member));
    }

    @EventHandler
    public void onProjectCreated(ProjectCreatedEvent projectCreatedEvent) {
        this.projectID = projectCreatedEvent.getProjectID();
        this.teamMemberRecruitment = projectCreatedEvent.getTeamMemberRecruitment();
    }

    @EventHandler
    public void onTeamMemberAddedEvent(TeamMemberAddedEvent teamMemberAddedEvent) {
        members.add(teamMemberAddedEvent.getMember());
    }



}
