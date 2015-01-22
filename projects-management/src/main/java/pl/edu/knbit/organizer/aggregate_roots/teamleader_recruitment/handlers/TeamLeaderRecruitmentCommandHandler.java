package pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment.handlers;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment.commands.ApplyForTeamLeaderCommand;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment.TeamLeaderRecruitment;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment.commands.OpenTeamLeaderRecruitmentCommand;
import pl.edu.knbit.organizer.aggregate_roots.teamleader_recruitment.commands.SelectTeamLeaderCommand;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */
public class TeamLeaderRecruitmentCommandHandler {

    private Repository<TeamLeaderRecruitment> repository;

    @CommandHandler
    public void handleOpenTeamLeaderRecruitmentCommand(OpenTeamLeaderRecruitmentCommand command) {
        TeamLeaderRecruitment teamLeaderRecruitment = new TeamLeaderRecruitment(command.getTeamLeaderRecruitmentId());
        repository.add(teamLeaderRecruitment);;
    }

    @CommandHandler
    public void handleApplyForTeamLeaderCommand(ApplyForTeamLeaderCommand command) {
        TeamLeaderRecruitment teamLeaderRecruitment = repository.load(command.getTeamLeaderRecruitmentId());
        teamLeaderRecruitment.applyForTeamLeader(command.getCandidate());
    }

    @CommandHandler
    public void handleSelectTeamLeaderCommand(SelectTeamLeaderCommand command) {
        TeamLeaderRecruitment teamLeaderRecruitment = repository.load(command.getTeamLeaderRecruitmentId());
        teamLeaderRecruitment.selectTeamLeader(command.getTeamLeader());
    }

    public void setRepository(Repository<TeamLeaderRecruitment> repository) {
        this.repository = repository;
    }
}
