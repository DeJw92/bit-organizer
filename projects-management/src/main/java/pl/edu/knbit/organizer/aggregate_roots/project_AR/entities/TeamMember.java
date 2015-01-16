package pl.edu.knbit.organizer.aggregate_roots.project_AR.entities;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedEntity;

/**
 * Created by Dawid Pawlak.
 */
public class TeamMember extends AbstractAnnotatedEntity {
    private String name;
    private String lastName;

    public TeamMember(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
