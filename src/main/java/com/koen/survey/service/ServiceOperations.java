package com.koen.survey.service;

import com.koen.survey.model.Survey;
import org.springframework.http.ResponseEntity;

public interface ServiceOperations {
    ResponseEntity<String> save(Object object);
    ResponseEntity<String> update(Object object);
    ResponseEntity<String> remove(Long id);
}
