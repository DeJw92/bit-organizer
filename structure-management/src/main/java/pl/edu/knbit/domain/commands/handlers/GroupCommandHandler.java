package pl.edu.knbit.domain.commands.handlers;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pl.edu.knbit.domain.aggregates.Group;
import pl.edu.knbit.domain.aggregates.GroupFactory;
import pl.edu.knbit.domain.commands.*;

/**
* Created by mwrona.
*/
public class GroupCommandHandler {

    private Repository<Group> groupRepository;

    @CommandHandler
    public void handleCreateGroup(CreateGroupCommand createGroupCommand){
        Group group = GroupFactory.create(createGroupCommand.getGroupId(), createGroupCommand.getName(),
                createGroupCommand.getDescription());
        groupRepository.add(group);
    }

    @CommandHandler
    public void handleAddMember(AddMemberCommand addMemberCommand){
        Group group = groupRepository.load(addMemberCommand.getGroupId());
        group.addMember(addMemberCommand.getMember());
    }

    @CommandHandler
    public void handleStartEnrollment(StartEnrollmentCommand startEnrollmentCommand){
        Group group = groupRepository.load(startEnrollmentCommand.getGroupId());
        group.startEnrollment();
    }

    @CommandHandler
    public void handleSelectParentGroup(SelectParentGroupCommand selectParentGroupCommand){
        Group group = groupRepository.load(selectParentGroupCommand.getGroupId());
        group.selectParentGroup(selectParentGroupCommand.getParentGroup());
    }

    @CommandHandler
    public void handleSelcetGroupSupervisor(SelectGroupSupervisorCommand selectGroupSupervisorCommand){
        Group group = groupRepository.load(selectGroupSupervisorCommand.getGroupId());
        group.selectGroupSupervisor(selectGroupSupervisorCommand.getGroupSupervisor());
    }

    @Autowired
    @Qualifier
    public void setGroupRepository(Repository<Group> groupRepository){
        this.groupRepository = groupRepository;
    }
}
