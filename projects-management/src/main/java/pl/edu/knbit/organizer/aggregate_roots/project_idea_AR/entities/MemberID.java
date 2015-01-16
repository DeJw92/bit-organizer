package pl.edu.knbit.organizer.aggregate_roots.project_idea_AR.entities;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedEntity;

/**
 * Created by eric
 */
public class MemberID extends AbstractAnnotatedEntity {
    private String ID;

    public MemberID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }
}
