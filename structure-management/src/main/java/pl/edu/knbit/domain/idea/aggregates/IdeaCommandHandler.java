package pl.edu.knbit.domain.idea.aggregates;

import pl.edu.knbit.domain.enrollment.aggregates.Enrollment;
import pl.edu.knbit.domain.enrollment.aggregates.EnrollmentFactory;
import pl.edu.knbit.domain.member.valueobjects.MemberId;
import pl.edu.knbit.domain.group.aggregates.Group;
import pl.edu.knbit.domain.idea.commands.*;
import pl.edu.knbit.domain.idea.exceptions.ParentGroupNotSelectedException;
import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.idea.valueobjects.IdeaId;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IdeaCommandHandler {
    private Repository<Idea> ideaRepository;
    private Repository<Group> groupRepository;
    private Repository<Enrollment> enrollmentRepository;

    @CommandHandler
    public void handleSubmitIdeaCommand(SubmitIdeaCommand submitIdeaCommand) {
        Idea idea = IdeaFactory.create(submitIdeaCommand.getIdeaId(), submitIdeaCommand.getTitle(), submitIdeaCommand.getDescription());
        ideaRepository.add(idea);
    }
    @CommandHandler
    public void handleSelectParentGroupCommand(SelectParentGroupCommand selectParentGroupCommand) {
        GroupId groupId = selectParentGroupCommand.getGroupId();
        groupRepository.load(groupId);
        IdeaId ideaId = selectParentGroupCommand.getIdeaId();
        Idea idea = ideaRepository.load(ideaId);
        idea.selectParentGroup(groupId);
    }

    @CommandHandler
    public void handleSelectGroupSupervisorCommand(SelectGroupSupervisorCommand selectGroupSupervisorCommand) throws ParentGroupNotSelectedException {
        GroupId groupId = selectGroupSupervisorCommand.getGroupId();
        groupRepository.load(groupId);
        IdeaId ideaId = selectGroupSupervisorCommand.getIdeaId();
        MemberId groupSupervisorId = selectGroupSupervisorCommand.getGroupSupervisorId();
        //TODO check if exists?
        Idea idea = ideaRepository.load(ideaId);
        GroupId parentGroupId = idea.getParentGroupId();
        if(parentGroupId == null) {
            throw new ParentGroupNotSelectedException(ideaId);
        }
        //TODO check if potential supervisor belongs to parent group
        idea.selectGroupSupervisor(groupSupervisorId);
    }

    @CommandHandler
    public void handleAcceptIdeaCommand(AcceptIdeaCommand acceptIdeaCommand) throws IllegalStateException {
        IdeaId ideaId = acceptIdeaCommand.getIdeaId();
        Idea idea = ideaRepository.load(ideaId);
        idea.accept();
    }

    @CommandHandler
    public void handleRejectIdeaCommand(RejectIdeaCommand rejectIdeaCommand) throws IllegalStateException {
        IdeaId ideaId = rejectIdeaCommand.getIdeaId();
        Idea idea = ideaRepository.load(ideaId);
        idea.reject();
    }

    @CommandHandler
    public void handleAbandonIdeaCommand(AbandonIdeaCommand abandonIdeaCommand) throws IllegalStateException {
        IdeaId ideaId = abandonIdeaCommand.getIdeaId();
        Idea idea = ideaRepository.load(ideaId);
        idea.abandon();
    }

    @CommandHandler
    public void handleCreateEnrollmentCommand(CreateEnrollmentCommand createEnrollmentCommand) {
        IdeaId ideaId = createEnrollmentCommand.getIdeaId();
        Idea idea = ideaRepository.load(ideaId);
        Enrollment enrollment = EnrollmentFactory.create(createEnrollmentCommand.getEnrollmentId(),
                createEnrollmentCommand.getTitle(),
                createEnrollmentCommand.getDescription(),
                createEnrollmentCommand.getEnrollmentConfiguration());
        enrollmentRepository.add(enrollment);
        idea.setEnrollmentId(createEnrollmentCommand.getEnrollmentId());
    }

    @Autowired
    @Qualifier("ideaRepository")
    public void setIdeaRepository(Repository<Idea> ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    @Autowired
    @Qualifier("groupRepository")
    public void setGroupRepository(Repository<Group> groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Autowired
    @Qualifier("enrollmentRepository")
    public void setEnrollmentRepository(Repository<Enrollment> enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }
}
