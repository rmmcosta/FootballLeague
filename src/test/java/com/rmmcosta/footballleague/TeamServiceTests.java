package com.rmmcosta.footballleague;

import com.rmmcosta.footballleague.entity.District;
import com.rmmcosta.footballleague.entity.Team;
import com.rmmcosta.footballleague.service.DistrictService;
import com.rmmcosta.footballleague.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamServiceTests {
    @Autowired
    TeamService teamService;
    @Autowired
    DistrictService districtService;

    @BeforeEach
    public void setup() {
        if (districtService.getDistrictById(1L) == null) {
            districtService.saveDistrict(new District(1L, "Lisboa"));
        }
    }

    @Test
    public void TeamLifeCycleTest() {
        District district = districtService.getDistrictById(1L);
        int initCount = teamService.getAllTeams().size();
        Long newTeamId = teamService.findNextTeamId();
        Team newTeam = new Team(newTeamId, "NoTeam", district);
        teamService.saveTeam(newTeam);
        assertEquals(initCount + 1, teamService.getAllTeams().size());
        assertEquals(newTeam, teamService.getTeamById(newTeamId));
    }
}
