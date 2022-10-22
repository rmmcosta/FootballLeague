package com.rmmcosta.footballleague.web;

import com.rmmcosta.footballleague.entity.District;
import com.rmmcosta.footballleague.entity.Result;
import com.rmmcosta.footballleague.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping
    public ResponseEntity<List<Result>> getResults() {
        return new ResponseEntity<>(resultService.getAllResults(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Result> getResult(@PathVariable Long id) {
        return new ResponseEntity<>(resultService.getResultById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Result> saveResult(@RequestBody Result result) {
        System.out.println(result);
        return new ResponseEntity<>(resultService.saveResult(result), HttpStatus.OK);
    }
}
