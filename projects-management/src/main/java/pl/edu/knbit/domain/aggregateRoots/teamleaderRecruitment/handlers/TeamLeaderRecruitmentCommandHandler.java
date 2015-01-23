package pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.handlers;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.TeamLeaderRecruitment;
import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.commands.ApplyForTeamLeaderCommand;
import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.commands.OpenTeamLeaderRecruitmentCommand;
import pl.edu.knbit.domain.aggregateRoots.teamleaderRecruitment.commands.SelectTeamLeaderCommand;

/**
 * Created by Bartosz Zurkowski on 06.01.15.
 */

@Component
public class TeamLeaderRecruitmentCommandHandler {

    @Autowired
    private Repository<TeamLeaderRecruitment> teamleaderRecruitmentRepository;

    @CommandHandler
    public void handleOpenTeamLeaderRecruitmentCommand(OpenTeamLeaderRecruitmentCommand command) {
        TeamLeaderRecruitment teamLeaderRecruitment = new TeamLeaderRecruitment(command.getTeamLeaderRecruitmentId());
        teamleaderRecruitmentRepository.add(teamLeaderRecruitment);
        ;
    }

    @CommandHandler
    public void handleApplyForTeamLeaderCommand(ApplyForTeamLeaderCommand command) {
        TeamLeaderRecruitment teamLeaderRecruitment = teamleaderRecruitmentRepository.load(command.getTeamLeaderRecruitmentId());
        teamLeaderRecruitment.applyForTeamLeader(command.getCandidate());
    }

    @CommandHandler
    public void handleSelectTeamLeaderCommand(SelectTeamLeaderCommand command) {
        TeamLeaderRecruitment teamLeaderRecruitment = teamleaderRecruitmentRepository.load(command.getTeamLeaderRecruitmentId());
        teamLeaderRecruitment.selectTeamLeader(command.getTeamLeader());
    }

    public void setTeamLeaderRecruitmentRepository(Repository<TeamLeaderRecruitment> teamLeaderRecruitmentRepository) {
        this.teamleaderRecruitmentRepository = teamLeaderRecruitmentRepository;
    }
}
