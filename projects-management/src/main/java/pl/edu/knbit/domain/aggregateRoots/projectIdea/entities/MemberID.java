package pl.edu.knbit.domain.aggregateRoots.projectIdea.entities;

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
