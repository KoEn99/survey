package com.koen.survey.repository;

import com.koen.survey.model.Survey;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepo extends JpaRepository<Survey, Long> {
    List<Survey> findBySurveyNameContainsIgnoreCase(String name, Sort sort);
}
