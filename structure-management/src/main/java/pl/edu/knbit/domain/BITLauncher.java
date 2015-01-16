package pl.edu.knbit.domain;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.knbit.domain.enrollment.commands.CreateEnrollmentCommand;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;

import java.util.UUID;

/**
 * @author mciolek
 */
public class BITLauncher {
    private CommandBus commandBus;
    private ClassPathXmlApplicationContext context;

    public static void main(String[] args) {


        BITLauncher bitLauncher = new BITLauncher();
        bitLauncher.launch();
        CreateEnrollmentCommand command = new CreateEnrollmentCommand(new EnrollmentId(UUID.randomUUID()), "", "", new EnrollmentConfiguration(10));
        bitLauncher.handleCommand(command);


    }

    private void handleCommand(Object command) {
        commandBus.dispatch(GenericCommandMessage.asCommandMessage(command));
    }

    private void launch() {
        context = new ClassPathXmlApplicationContext("/application-context.xml");
        commandBus = context.getBean("commandBus", CommandBus.class);
    }
}
