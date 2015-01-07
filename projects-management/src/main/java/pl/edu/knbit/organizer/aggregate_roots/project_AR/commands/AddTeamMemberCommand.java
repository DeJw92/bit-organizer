package pl.edu.knbit.organizer.aggregate_roots.project_AR.commands;

import pl.edu.knbit.organizer.aggregate_roots.project_AR.entities.Member;
import pl.edu.knbit.organizer.aggregate_roots.project_AR.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class AddTeamMemberCommand extends AbstractProjectCommand{

    private final Member member;

    public AddTeamMemberCommand(ProjectID projectID, Member member) {
        super(projectID);
        this.member = member;
    }

    public Member getMember() {
        return member;
    }
}
