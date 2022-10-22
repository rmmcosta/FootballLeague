package com.rmmcosta.footballleague.service;

import com.rmmcosta.footballleague.entity.Team;
import com.rmmcosta.footballleague.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        Team team = teamOptional.orElseThrow(TeamNotFoundException::new);
        return team;
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Long findNextTeamId() {
        Optional<Team> maxTeamById = getAllTeams()
                .stream()
                .max(Comparator.comparing(Team::getId));
        return maxTeamById.isEmpty() ? 1 : maxTeamById.get().getId() + 1;
    }
}
