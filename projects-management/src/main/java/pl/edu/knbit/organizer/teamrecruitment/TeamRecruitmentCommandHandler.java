package pl.edu.knbit.organizer.teamrecruitment;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import pl.edu.knbit.organizer.teamrecruitment.commands.*;

public class TeamRecruitmentCommandHandler {

    // TODO Add DI
    private Repository<TeamRecruitment> repository;

    @CommandHandler
    public void handleAppointMeetingCommand(AppointMeetingCommand command) {
        // TODO Should we validate if meeting can be appointed (permissions etc.)?
        final TeamRecruitment teamRecruitment = repository.load(command.getTeamRecruitmentId());
        teamRecruitment.appointMeeting(command.getMemberId());
    }

    @CommandHandler
    public void handleApplyForProjectCommand(ApplyForProjectCommand command) {
        final TeamRecruitment teamRecruitment = repository.load(command.getTeamRecruitmentId());
        teamRecruitment.applyForProject(command.getMemberId());
    }

    @CommandHandler
    public void handleAcceptMemberCommand(AcceptMemberCommand command) {
        final TeamRecruitment teamRecruitment = repository.load(command.getTeamRecruitmentId());
        teamRecruitment.acceptMember(command.getMemberId());
    }

    @CommandHandler
    public void handleRejectMemberCommand(RejectMemberCommand command) {
        final TeamRecruitment teamRecruitment = repository.load(command.getTeamRecruitmentId());
        teamRecruitment.rejectMember(command.getMemberId());
    }

    @CommandHandler
    public void handleCloseTeamRecruitmentCommand(CloseTeamRecruitmentCommand command) {
        final TeamRecruitment teamRecruitment = repository.load(command.getTeamRecruitmentId());
        teamRecruitment.closeRecruitment();
    }

    @CommandHandler
    public void handleFinishTeamRecruitmentCommand(FinishTeamRecruitmentCommand command) {
        final TeamRecruitment teamRecruitment = repository.load(command.getTeamRecruitmentId());
        teamRecruitment.finishRecruitment();
    }

    public void setRepository(Repository<TeamRecruitment> repository) {
        this.repository = repository;
    }

}
