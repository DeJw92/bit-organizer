package pl.edu.knbit.domain.commands.handlers;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pl.edu.knbit.domain.aggregates.Enrollment;
import pl.edu.knbit.domain.aggregates.EnrollmentFactory;
import pl.edu.knbit.domain.commands.AddMembershipRequestCommand;
import pl.edu.knbit.domain.commands.CancelEnrollmentCommand;
import pl.edu.knbit.domain.commands.CloseEnrollmentCommand;
import pl.edu.knbit.domain.commands.CreateEnrollmentCommand;

public class EnrollmentCommandsHandler {

    private Repository<Enrollment> enrollmentRepository;

    @CommandHandler
    public void handleCreateEnrollmentCommand(CreateEnrollmentCommand command) {
        Enrollment enrollment = EnrollmentFactory.create(command.getEnrollmentId(), command.getTitle(),
                command.getDescription(), command.getConfiguration());
        enrollmentRepository.add(enrollment);
    }

    @CommandHandler
    public void handleCancelEnrollmentCommand(CancelEnrollmentCommand command) {
        Enrollment enrollment = enrollmentRepository.load(command.getEnrollmentId());
        enrollment.cancelEnrollment();
    }

    @CommandHandler
    public void handleCloseEnrollmentCommand(CloseEnrollmentCommand command) {
        Enrollment enrollment = enrollmentRepository.load(command.getEnrollmentId());
        enrollment.closeEnrollment();
    }

    @CommandHandler
    public void handleAddMembershipRequestCommand(AddMembershipRequestCommand command) {
        Enrollment enrollment = enrollmentRepository.load(command.getEnrollmentId());
        enrollment.addMembershipRequest(command.getMembershipRequest());
    }

    @Autowired
    @Qualifier("enrollmentRepository")
    public void setEnrollmentRepository(Repository<Enrollment> enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }
}
