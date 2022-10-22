package com.rmmcosta.footballleague.service;

import com.rmmcosta.footballleague.entity.District;
import com.rmmcosta.footballleague.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<District> getAllDistricts() {
        return (List<District>) districtRepository.findAll();
    }

    @Override
    public District getDistrictById(Long id) {
        Optional<District> optionalDistrict = districtRepository.findById(id);
        District district = optionalDistrict.orElseThrow(DistrictNotFoundException::new);
        return district;
    }

    @Override
    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public Long findNextDistrictId() {
        Optional<District> maxDistrictById = getAllDistricts()
                .stream()
                .max(Comparator.comparing(District::getId));
        return maxDistrictById.isEmpty() ? 1 : maxDistrictById.get().getId() + 1;
    }
}
