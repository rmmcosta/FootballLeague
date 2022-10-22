package com.rmmcosta.footballleague.service;

import com.rmmcosta.footballleague.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();

    Team getTeamById(Long id);

    Team saveTeam(Team team);

    Long findNextTeamId();
}
