package pl.edu.knbit.integration;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.repository.Repository;
import org.axonframework.unitofwork.DefaultUnitOfWork;
import org.axonframework.unitofwork.UnitOfWork;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.knbit.domain.enrollment.aggregates.Enrollment;
import pl.edu.knbit.domain.enrollment.commands.CreateEnrollmentCommand;
import pl.edu.knbit.domain.enrollment.commands.EndEnrollmentCommand;
import pl.edu.knbit.domain.enrollment.commands.StartEnrollmentCommand;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentStatus;
import pl.edu.knbit.domain.group.commands.CreateGroupCommand;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author mciolek
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ContextAwareTest {
    private EnrollmentId ENROLLMENT_ID = new EnrollmentId(UUID.randomUUID());
    private UnitOfWork unitOfWork;

    @Autowired
    private CommandBus commandBus;

    @Autowired
    private Repository<Enrollment> enrollmentRepository;


    @Before
    public void setUp() throws Exception {
        unitOfWork = DefaultUnitOfWork.startAndGet();
    }

    @After
    public void tearDown() throws Exception {
        unitOfWork.commit();

    }

    private void handleCommand(Object createEnrollmentCommand) {
        CommandMessage commandMessage = GenericCommandMessage.asCommandMessage(createEnrollmentCommand);
        commandBus.dispatch(commandMessage);
    }


    @Test
    @DirtiesContext
    public void enrollmentStatesTest() throws Exception {
        //given
        handleCommand(new CreateEnrollmentCommand(ENROLLMENT_ID, "Title", "Description", new EnrollmentConfiguration(10)));

        //when
        handleCommand(new StartEnrollmentCommand(ENROLLMENT_ID));

        //then
        Enrollment enrollment = enrollmentRepository.load(ENROLLMENT_ID);
        assertEquals(enrollment.getStatus(), EnrollmentStatus.STARTED);
    }

    @Test
    @DirtiesContext
    @Ignore
    public void twoAggregates() throws Exception {
        //given
        TestCommandHandler<CreateGroupCommand> commandHandler = new TestCommandHandler<>();
        subscribeToCommand(commandHandler, CreateGroupCommand.class);
        handleCommand(new CreateEnrollmentCommand(ENROLLMENT_ID, "Title", "Description", new EnrollmentConfiguration(10)));
        handleCommand(new StartEnrollmentCommand(ENROLLMENT_ID));


        //when
        handleCommand(new EndEnrollmentCommand(ENROLLMENT_ID));

        //then
        commandHandler.getHandledFuture().thenRunAsync(() -> assertTrue(commandHandler.getHandled().isPresent()));

        commandHandler.getHandledFuture().join();
    }

    private void subscribeToCommand(TestCommandHandler commandHandler, Class clazz) {
        commandBus.subscribe(clazz.getName(), commandHandler);
    }
}
