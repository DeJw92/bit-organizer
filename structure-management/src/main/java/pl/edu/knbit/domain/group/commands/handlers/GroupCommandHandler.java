package pl.edu.knbit.domain.group.commands.handlers;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.knbit.domain.group.aggregates.Group;
import pl.edu.knbit.domain.group.aggregates.GroupFactory;
import pl.edu.knbit.domain.group.commands.AddMemberCommand;
import pl.edu.knbit.domain.group.commands.CreateGroupCommand;
import pl.edu.knbit.domain.group.commands.StartEnrollmentCommand;

/**
* Created by mwrona.
*/
@Component
public class GroupCommandHandler {

    private Repository<Group> groupRepository;

    @CommandHandler
    public void handleCreateGroup(CreateGroupCommand createGroupCommand){
        Group group = GroupFactory.create(createGroupCommand.getGroupId(), createGroupCommand.getParentGroup(),
                createGroupCommand.getName(), createGroupCommand.getDescription(), createGroupCommand.getGroupSupervisor());
        groupRepository.add(group);
    }

    @CommandHandler
    public void handleAddMember(AddMemberCommand addMemberCommand){
        Group group = groupRepository.load(addMemberCommand.getGroup());
        group.addMember(addMemberCommand.getUser());
    }

    @CommandHandler
    public void handleStartEnrollment(StartEnrollmentCommand startEnrollmentCommand){
        Group group = groupRepository.load(startEnrollmentCommand.getGroup());
        group.startEnrollment();
    }

    @Autowired
    public void setGroupRepository(Repository<Group> groupRepository){
        this.groupRepository = groupRepository;
    }
}
