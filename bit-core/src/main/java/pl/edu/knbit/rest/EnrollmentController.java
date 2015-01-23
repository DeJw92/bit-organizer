package pl.edu.knbit.rest;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.knbit.readModel.objects.Enrollment;
import pl.edu.knbit.readModel.repository.EnrollmentReadRepository;
import pl.edu.knbit.rest.requestObjects.CreateEnrollmentRequest;

import java.util.List;

/**
 * @author mciolek
 */
@Controller
public class EnrollmentController {
    private final static Logger LOGGER = LoggerFactory.getLogger(EnrollmentController.class);
    @Autowired
    private CommandBus commandBus;

    @Autowired
    private EnrollmentReadRepository readRepository;

    @RequestMapping(value = "/enrollments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Enrollment>> getEnrollments() {
        List<Enrollment> enrollments = readRepository.getAll();
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollments", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createEnrollment(@RequestBody CreateEnrollmentRequest request) {

        commandBus.dispatch(GenericCommandMessage.asCommandMessage(request.asCommand()));
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @ExceptionHandler
    public void handleException(Exception exception) {
        LOGGER.error("Error...", exception);
    }
}