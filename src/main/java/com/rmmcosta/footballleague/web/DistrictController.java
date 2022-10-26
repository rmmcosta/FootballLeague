package com.rmmcosta.footballleague.web;

import com.rmmcosta.footballleague.entity.District;
import com.rmmcosta.footballleague.entity.Team;
import com.rmmcosta.footballleague.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping
    public ResponseEntity<List<District>> getDistricts() {
        return new ResponseEntity<>(districtService.getAllDistricts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<District> getDistrict(@PathVariable Long id) {
        return new ResponseEntity<>(districtService.getDistrictById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<District> saveDistrict(@RequestBody District district) {
        System.out.println(district);
        return new ResponseEntity<>(districtService.saveDistrict(district), HttpStatus.CREATED);
    }
}
