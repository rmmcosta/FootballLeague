package com.rmmcosta.footballleague.repository;

import com.rmmcosta.footballleague.entity.District;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends CrudRepository<District, Long> {
}
