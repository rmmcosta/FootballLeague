package com.rmmcosta.footballleague.service;

import com.rmmcosta.footballleague.entity.District;

import java.util.List;

public interface DistrictService {
    List<District> getAllDistricts();

    District getDistrictById(Long id);

    District saveDistrict(District district);

    Long findNextDistrictId();
}
