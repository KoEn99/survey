package com.koen.survey.service;

import com.koen.survey.model.QuestionSurvey;
import com.koen.survey.model.Survey;
import com.koen.survey.repository.QuestionSurveyRepo;
import com.koen.survey.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuestionService implements ServiceOperations {
    @Autowired
    QuestionSurveyRepo questionSurveyRepo;
    @Autowired
    SurveyRepo surveyRepo;
    @Override
    public ResponseEntity<String> save(Object object) {
        try {
            QuestionSurvey questionSurvey = (QuestionSurvey) object;
            Optional<Survey> survey = surveyRepo.findById(questionSurvey.getSurvey().getId());
            survey.ifPresent(questionSurvey::setSurvey);
            questionSurveyRepo.save(questionSurvey);
        }
        catch (Exception ex){
            return new ResponseEntity<String>("Произошла ошибка", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("Вопрос успешно создан", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> update(Object object) {
        QuestionSurvey questionSurvey = (QuestionSurvey) object;
        Optional<QuestionSurvey> questionSurveyOptional = questionSurveyRepo.findById(questionSurvey.getId());
        if (questionSurveyOptional.isPresent()){
            save(questionSurvey);
        } else
            return new ResponseEntity<String>("Вопроса не сущетсвует", HttpStatus.CONFLICT);
        return new ResponseEntity<String>("Вопрос успешно обновлен", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> remove(Long id) {
        try {
            Optional<QuestionSurvey> questionSurveyOptional = questionSurveyRepo.findById(id);
            questionSurveyOptional.ifPresent(value -> questionSurveyRepo.delete(value));
        }
        catch (Exception ex){
            return new ResponseEntity<String>("Произошла ошибка", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("Вопрос успешно удален", HttpStatus.OK);
    }
    public List<QuestionSurvey> getAllBySurveyIdOrderByIndex(Long id){
        return questionSurveyRepo.findAllBySurveyIdOrderByIndex(id);
    }
}
