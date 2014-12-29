package ddd.domain.events;

import ddd.domain.entities.Member;
import ddd.domain.value_objects.ProjectID;

/**
 * Created by Dawid Pawlak.
 */
public class MemberRejectedEvent extends AbstractProjectEvent{

    private final Member member;

    public MemberRejectedEvent(ProjectID projectID, Member member) {
        super(projectID);
        this.member = member;
    }

    public Member getMember() {
        return member;
    }
}
