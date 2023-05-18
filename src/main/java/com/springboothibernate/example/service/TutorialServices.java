package com.springboothibernate.example.service;

import com.springboothibernate.example.Tutorial;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TutorialServices {
    ResponseEntity<List<Tutorial>> getAllTutorials(String title);
    ResponseEntity<Tutorial> getTutorialsById(long id);
    ResponseEntity<Tutorial> createTutorials(Tutorial tutorial);
    ResponseEntity<Tutorial> updateTutorial(long id, Tutorial tutorial);
    ResponseEntity<HttpStatus> deleteTutorials(long id);
    ResponseEntity<HttpStatus> deleteAllTutorials();
    ResponseEntity<List<Tutorial>> findByPublished();
}
