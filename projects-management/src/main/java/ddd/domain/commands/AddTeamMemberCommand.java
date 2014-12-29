package ddd.domain.commands;

import ddd.domain.entities.Member;
import ddd.domain.value_objects.ProjectID;

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
