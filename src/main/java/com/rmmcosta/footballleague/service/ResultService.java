package com.rmmcosta.footballleague.service;

import com.rmmcosta.footballleague.entity.Result;

import java.util.List;

public interface ResultService {
    List<Result> getAllResults();

    List<Result> getHomeResultsByTeam(Long teamId);

    List<Result> getAwayResultsByTeam(Long teamId);

    Result getResultById(Long id);

    Result saveResult(Result result);

    Long findNextResultId();
}
