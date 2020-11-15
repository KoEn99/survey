package com.koen.survey.controller;

import com.koen.survey.model.Survey;
import com.koen.survey.repository.SurveyRepo;
import com.koen.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    SurveyService surveyService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> createSurvey(@RequestBody Survey survey) {
        return surveyService.save(survey);
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> updateSurvey(@RequestBody Survey survey) {
        return surveyService.update(survey);
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Survey> findAll(@RequestParam Optional<String> name,
                                @RequestParam Optional<String> sortBy,
                                @RequestParam Optional<String> index) {
        return surveyService.getWithFilterAllSurvey(name, sortBy, index);
    }
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> removeSurvey(@PathVariable Long id) {
        return surveyService.remove(id);
    }
}