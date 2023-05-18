package com.springboothibernate.example.controller;

import com.springboothibernate.example.Tutorial;
import com.springboothibernate.example.repository.TutorialRepository;
import com.springboothibernate.example.service.TutorialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {
    TutorialServices tutorialServices;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        return ResponseEntity.ok(tutorialServices.getAllTutorials(title).getBody());
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialsById(@PathVariable("id") long id) {
        return ResponseEntity.ok(tutorialServices.getTutorialsById(id).getBody());
    }
    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorials(@RequestParam Tutorial tutorial) {
        return ResponseEntity.ok(tutorialServices.createTutorials(tutorial).getBody());
    }
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        return ResponseEntity.ok(tutorialServices.updateTutorial(id,tutorial).getBody());
    }
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorials(@PathVariable("id") long id) {
        return ResponseEntity.ok(tutorialServices.deleteTutorials(id).getBody());
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        return ResponseEntity.ok(tutorialServices.deleteAllTutorials().getBody());
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        return ResponseEntity.ok(tutorialServices.findByPublished().getBody());
    }
}
