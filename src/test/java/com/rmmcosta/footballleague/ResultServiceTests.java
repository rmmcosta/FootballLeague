package com.rmmcosta.footballleague;

import com.rmmcosta.footballleague.entity.District;
import com.rmmcosta.footballleague.entity.Result;
import com.rmmcosta.footballleague.entity.Team;
import com.rmmcosta.footballleague.repository.ResultRepository;
import com.rmmcosta.footballleague.service.DistrictService;
import com.rmmcosta.footballleague.service.ResultService;
import com.rmmcosta.footballleague.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResultServiceTests {
    @Autowired
    private ResultService resultService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private TeamService teamService;

    private District district;
    private Team awayTeam;
    private Team homeTeam;

    @BeforeEach
    public void setup() {
        //guarantee that at least one district exists
        District anyDistrict;
        if (districtService.getAllDistricts().size() == 0) {
            anyDistrict = districtService.saveDistrict(new District(1L, "Lisboa"));
        } else {
            anyDistrict = districtService.getAllDistricts().get(0);
        }
        // guarantee that at least 2 teams exist
        if (teamService.getAllTeams().size() == 0) {
            teamService.saveTeam(
                    new Team(
                            1L,
                            "Team1",
                            anyDistrict
                    )
            );
            teamService.saveTeam(
                    new Team(
                            2L,
                            "Team2",
                            anyDistrict
                    )
            );
        }
        if (teamService.getAllTeams().size() == 1) {
            teamService.saveTeam(
                    new Team(
                            teamService.findNextTeamId(),
                            "TeamXpto",
                            anyDistrict
                    )
            );
        }
    }

    @Test
    public void ResultsLifeCycleTest() {
        int initResultsCount = resultService.getAllResults().size();
        List<Team> teams = teamService.getAllTeams();
        Team homeTeam = teams.get(0);
        Team awayTeam = teams.get(1);
        Long nextResultId = resultService.findNextResultId();
        Result result = new Result(
                nextResultId,
                homeTeam,
                awayTeam,
                3,
                2
        );
        result = resultService.saveResult(result);
        Long result1stId = result.getId();
        assertEquals(initResultsCount + 1, resultService.getAllResults().size());
        assertEquals(result, resultService.getResultById(result.getId()));
        Result result2 = new Result(
                nextResultId + 1,
                awayTeam,
                homeTeam,
                1,
                1
        );
        result2 = resultService.saveResult(result2);
        Long result2ndId = result2.getId();
        assertEquals(initResultsCount + 2, resultService.getAllResults().size());
        assertEquals(result2, resultService.getResultById(result2.getId()));
        assertEquals(
                result,
                resultService
                        .getHomeResultsByTeam(
                                homeTeam.getId()
                        )
                        .stream()
                        .filter(r -> r.getId() == result1stId)
                        .toList()
                        .get(0)
        );
        assertEquals(
                result2,
                resultService
                        .getAwayResultsByTeam(
                                homeTeam.getId()
                        )
                        .stream()
                        .filter(r -> r.getId() == result2ndId)
                        .toList()
                        .get(0)
        );
    }
}
