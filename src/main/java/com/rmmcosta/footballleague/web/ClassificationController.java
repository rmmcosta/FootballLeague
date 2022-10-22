package com.rmmcosta.footballleague.web;

import com.rmmcosta.footballleague.entity.Classification;
import com.rmmcosta.footballleague.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classification")
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    @GetMapping
    public ResponseEntity<List<Classification>> getClassifications() {
        return new ResponseEntity<>(classificationService.getClassification(), HttpStatus.OK);
    }
}
