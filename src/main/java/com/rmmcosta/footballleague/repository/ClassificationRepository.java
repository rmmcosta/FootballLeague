package com.rmmcosta.footballleague.repository;

import com.rmmcosta.footballleague.entity.Classification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends CrudRepository<Classification, Long> {
}
