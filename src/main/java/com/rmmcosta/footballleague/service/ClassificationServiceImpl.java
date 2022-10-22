package com.rmmcosta.footballleague.service;

import com.rmmcosta.footballleague.entity.Classification;
import com.rmmcosta.footballleague.entity.Result;
import com.rmmcosta.footballleague.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
    private ResultService resultService;
    @Autowired
    private TeamService teamService;

    @Override
    public List<Classification> getClassification() {
        List<Team> teams = teamService.getAllTeams();
        List<Classification> classifications = new ArrayList<>();
        for (Team t : teams) {
            List<Result> homeResults = resultService.getHomeResultsByTeam(t.getId());
            int points = 0;
            int goalsScored = 0;
            int goalsSuffered = 0;
            for (Result r : homeResults) {
                goalsScored += r.getGoalsScored();
                goalsSuffered += r.getGoalsSuffered();
                if (r.getGoalsScored() > r.getGoalsSuffered()) {
                    points += 3;
                }
                if (r.getGoalsScored() == r.getGoalsSuffered()) {
                    points += 1;
                }
            }
            List<Result> awayResults = resultService.getAwayResultsByTeam(t.getId());
            for (Result r : awayResults) {
                goalsScored += r.getGoalsSuffered();
                goalsSuffered += r.getGoalsScored();
                if (r.getGoalsSuffered() > r.getGoalsScored()) {
                    points += 3;
                }
                if (r.getGoalsScored() == r.getGoalsSuffered()) {
                    points += 1;
                }
            }
            classifications.add(new Classification(t.getName(), points, goalsScored, goalsSuffered));
        }
        return classifications;
    }
}
