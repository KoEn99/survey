package com.koen.survey.controller;

import com.koen.survey.model.QuestionSurvey;
import com.koen.survey.model.Survey;
import com.koen.survey.service.QuestionService;
import com.koen.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> createSurvey(@RequestBody QuestionSurvey questionSurvey) {
        return questionService.save(questionSurvey);
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> updateSurvey(@RequestBody QuestionSurvey questionSurvey) {
        return questionService.update(questionSurvey);
    }
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<QuestionSurvey> findAll(@PathVariable Long id) {
        return questionService.getAllBySurveyIdOrderByIndex(id);
    }
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> removeSurvey(@PathVariable Long id) {
        return questionService.remove(id);
    }
}
