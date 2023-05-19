package com.springboothibernate.example.controller;

import com.springboothibernate.example.model.Tutorial;
import com.springboothibernate.example.service.TutorialServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TutorialController {
    private final TutorialServices tutorialServices;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        return ResponseEntity.ok(tutorialServices.getAllTutorials(title).getBody());
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialsById(@PathVariable("id") long id) {
        return ResponseEntity.ok(tutorialServices.getTutorialsById(id).getBody());
    }
    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorials(@RequestBody Tutorial tutorial) {
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
