package pl.edu.knbit.domain.commands.handlers;

import pl.edu.knbit.domain.aggregates.enrollment.Enrollment;
import pl.edu.knbit.domain.aggregates.enrollment.EnrollmentFactory;
import pl.edu.knbit.domain.aggregates.group.Group;
import pl.edu.knbit.domain.aggregates.idea.Idea;
import pl.edu.knbit.domain.aggregates.idea.IdeaFactory;
import pl.edu.knbit.domain.commands.idea.*;
import pl.edu.knbit.domain.exceptions.ParentGroupNotSelectedException;
import pl.edu.knbit.domain.valueobjects.GroupId;
import pl.edu.knbit.domain.valueobjects.IdeaId;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.knbit.domain.valueobjects.UserId;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentConfiguration;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

import java.util.UUID;

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

        UserId groupSupervisorId = selectGroupSupervisorCommand.getGroupSupervisorId();
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

        EnrollmentId enrollmentId = createEnrollmentCommand.getEnrollmentId();
        String title = createEnrollmentCommand.getTitle();
        String description = createEnrollmentCommand.getDescription();
        EnrollmentConfiguration enrollmentConfiguration = createEnrollmentCommand.getEnrollmentConfiguration();

        Enrollment enrollment = EnrollmentFactory.create(enrollmentId, title, description, enrollmentConfiguration);
        enrollmentRepository.add(enrollment);

        Idea idea = ideaRepository.load(ideaId);
        idea.setEnrollment(enrollmentId);
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
}
