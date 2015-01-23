package pl.edu.knbit.readModel.repository;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.stereotype.Repository;
import pl.edu.knbit.domain.enrollment.events.EnrollmentCreatedEvent;
import pl.edu.knbit.readModel.core.MemoryRepository;
import pl.edu.knbit.readModel.objects.Enrollment;

/**
 * @author mciolek
 */
@Repository
public class EnrollmentReadRepository extends MemoryRepository<String, Enrollment> {

    @EventHandler
    public void handleEnrollmentCreatedEvent(EnrollmentCreatedEvent event) {
        add(new Enrollment(event.getEnrollmentId().toString(), event.getTitle()));
    }
}
