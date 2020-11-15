package com.koen.survey.service;

import com.koen.survey.model.Survey;
import com.koen.survey.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService implements ServiceOperations{
    @Autowired
    SurveyRepo surveyRepo;
    @Override
    public ResponseEntity<String> save(Object object) {
        try {
            Survey survey = (Survey) object;
            surveyRepo.save(survey);
        }
        catch (Exception ex){
            return new ResponseEntity<String>("Произошла ошибка", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("Опрос успешно создан", HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<String> update(Object object){
        Survey survey = (Survey)object;
        Optional<Survey> survey1 = surveyRepo.findById(survey.getId());
        if (survey1.isPresent()){
            save(survey);
        } else
            return new ResponseEntity<String>("Такой записи не существует", HttpStatus.CONFLICT);
        return new ResponseEntity<String>("Запись успешно обновлена", HttpStatus.OK);
    }
    public List<Survey> getWithFilterAllSurvey(Optional<String> name,
                                               Optional<String> sortBy,
                                               Optional<String> index){
        if (!index.isPresent())
            return surveyRepo.findBySurveyNameContainsIgnoreCase(
                    name.orElse(""),
                    Sort.by(Sort.Direction.ASC,
                            sortBy.orElse("id")));
        else
            return surveyRepo.findBySurveyNameContainsIgnoreCase(
                    name.orElse(""),
                    Sort.by(Sort.Direction.DESC, sortBy.orElse("id")));
    }

    @Override
    public ResponseEntity<String> remove(Long id) {
        try {
            Optional<Survey> survey = surveyRepo.findById(id);
            survey.ifPresent(value -> surveyRepo.delete(value));
        }
        catch (Exception ex){
            return new ResponseEntity<String>("Произошла ошибка", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("Опрос успешно удален", HttpStatus.OK);
    }
}
