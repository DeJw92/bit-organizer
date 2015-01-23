package pl.edu.knbit.domain.aggregateRoots.teamRecruitment.handlers;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.knbit.domain.aggregateRoots.teamRecruitment.TeamRecruitment;
import pl.edu.knbit.domain.aggregateRoots.teamRecruitment.commands.*;

@Component
public class TeamRecruitmentCommandHandler {

    @Autowired
    private Repository<TeamRecruitment> teamRecruitmentRepository;

    @CommandHandler
    public void handleAppointMeetingCommand(AppointMeetingCommand command) {
        // TODO Should we validate if meeting can be appointed (permissions etc.)?
        final TeamRecruitment teamRecruitment = teamRecruitmentRepository.load(command.getTeamRecruitmentId());
        teamRecruitment.appointMeeting(command.getMemberId());
    }

    @CommandHandler
    public void handleApplyForProjectCommand(ApplyForProjectCommand command) {
        final TeamRecruitment teamRecruitment = teamRecruitmentRepository.load(command.getTeamRecruitmentId());
        teamRecruitment.applyForProject(command.getMemberId());
    }

    @CommandHandler
    public void handleAcceptMemberCommand(AcceptMemberCommand command) {
        final TeamRecruitment teamRecruitment = teamRecruitmentRepository.load(command.getTeamRecruitmentId());
        teamRecruitment.acceptMember(command.getMemberId());
    }

    @CommandHandler
    public void handleRejectMemberCommand(RejectMemberCommand command) {
        final TeamRecruitment teamRecruitment = teamRecruitmentRepository.load(command.getTeamRecruitmentId());
        teamRecruitment.rejectMember(command.getMemberId());
    }

    @CommandHandler
    public void handleCloseTeamRecruitmentCommand(CloseTeamRecruitmentCommand command) {
        final TeamRecruitment teamRecruitment = teamRecruitmentRepository.load(command.getTeamRecruitmentId());
        teamRecruitment.closeRecruitment();
    }

    @CommandHandler
    public void handleFinishTeamRecruitmentCommand(FinishTeamRecruitmentCommand command) {
        final TeamRecruitment teamRecruitment = teamRecruitmentRepository.load(command.getTeamRecruitmentId());
        teamRecruitment.finishRecruitment();
    }

    public void setTeamRecruitmentRepository(Repository<TeamRecruitment> teamRecruitmentRepository) {
        this.teamRecruitmentRepository = teamRecruitmentRepository;
    }

}
