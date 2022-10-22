package com.rmmcosta.footballleague;

import com.rmmcosta.footballleague.entity.District;
import com.rmmcosta.footballleague.service.DistrictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DistrictServiceTests {
    @Autowired
    private DistrictService districtService;

    @Test
    public void DistrictLifeCycleTest() {
        int initCount = districtService.getAllDistricts().size();
        Long newDistrictId = districtService.findNextDistrictId();
        District district = new District(newDistrictId, "Xpto");
        districtService.saveDistrict(district);
        assertEquals(initCount + 1, districtService.getAllDistricts().size());
        assertEquals(district, districtService.getDistrictById(newDistrictId));
    }
}
