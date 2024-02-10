package org.example.studentmanagementsystem.controller;

import org.example.studentmanagementsystem.entity.Quiz;
import org.example.studentmanagementsystem.repository.QuizRepository;
import org.example.studentmanagementsystem.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Create
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return quizService.save(quiz);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") int id) {
        return quizService.findById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") int id, @RequestBody Quiz updatedQuiz) {
        ResponseEntity<Quiz> existingQuiz = quizService.findById(id);
        if (existingQuiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedQuiz.setId(id); // Ensure the ID is set to the correct value
        quizService.update(updatedQuiz);
        return new ResponseEntity<>(updatedQuiz, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable("id") int id) {
        return quizService.delete(id);
    }

    // Retrieve all quizzes
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return quizService.findAll();
    }
}
