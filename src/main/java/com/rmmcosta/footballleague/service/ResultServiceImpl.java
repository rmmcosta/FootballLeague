package com.rmmcosta.footballleague.service;

import com.rmmcosta.footballleague.entity.Result;
import com.rmmcosta.footballleague.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Override
    public List<Result> getAllResults() {
        return (List<Result>) resultRepository.findAll();
    }

    @Override
    public List<Result> getHomeResultsByTeam(Long teamId) {
        return resultRepository.getHomeResults(teamId);
    }

    @Override
    public List<Result> getAwayResultsByTeam(Long teamId) {
        return resultRepository.getAwayResults(teamId);
    }

    @Override
    public Result getResultById(Long id) {
        Optional<Result> resultOptional = resultRepository.findById(id);
        Result result = resultOptional.orElseThrow(ResultNotFoundException::new);
        return result;
    }

    @Override
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public Long findNextResultId() {
        Optional<Result> maxResultById = getAllResults()
                .stream()
                .max(Comparator.comparing(Result::getId));
        return maxResultById.isEmpty() ? 1 : maxResultById.get().getId() + 1;
    }
}
