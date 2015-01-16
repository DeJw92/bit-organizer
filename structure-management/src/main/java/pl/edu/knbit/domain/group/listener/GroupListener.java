package pl.edu.knbit.domain.group.listener;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.knbit.domain.enrollment.events.EnrollmentEndedEvent;
import pl.edu.knbit.domain.group.commands.CreateGroupCommand;
import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.group.valueobjects.UserId;

import java.util.UUID;

/**
 * @author mciolek
 */
@Component
public class GroupListener {
    @Autowired
    private CommandBus commandBus;

    @EventHandler
    public void handleEnrollmentEndEvent(EnrollmentEndedEvent event){
        GroupId groupId = new GroupId(UUID.randomUUID());
        UserId userId = new UserId(UUID.randomUUID());
        commandBus.dispatch(GenericCommandMessage.asCommandMessage(new CreateGroupCommand(groupId, null, "", "", userId)));
    }
}
