package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.entities;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedEntity;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment_AR.value_objects.MemberId;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class Member extends AbstractAnnotatedEntity {

    private MemberId id;

    private String firstName;

    private String lastName;

    public Member(MemberId id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MemberId getId() {
        return id;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
