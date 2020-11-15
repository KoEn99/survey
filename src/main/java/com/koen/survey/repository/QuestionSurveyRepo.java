package com.koen.survey.repository;

import com.koen.survey.model.QuestionSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionSurveyRepo extends JpaRepository<QuestionSurvey, Long> {
    List<QuestionSurvey> findAllBySurveyIdOrderByIndex(Long id);
}
