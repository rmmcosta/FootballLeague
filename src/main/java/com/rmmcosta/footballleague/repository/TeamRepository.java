package com.rmmcosta.footballleague.repository;

import com.rmmcosta.footballleague.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
}
