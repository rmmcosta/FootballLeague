package com.rmmcosta.footballleague.repository;

import com.rmmcosta.footballleague.entity.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {
    @Query("Select r from Result r where r.homeTeamId.id = :teamId")
    public List<Result> getHomeResults(Long teamId);
    @Query("Select r from Result r where r.awayTeamId.id = :teamId")
    public List<Result> getAwayResults(Long teamId);
}
