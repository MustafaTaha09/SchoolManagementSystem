package org.example.studentmanagementsystem.controller;

import org.example.studentmanagementsystem.entity.Quiz;
import org.example.studentmanagementsystem.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;

    // Create
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        quizRepository.save(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") int id) {
        Quiz quiz = quizRepository.findById(id);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") int id, @RequestBody Quiz updatedQuiz) {
        Quiz existingQuiz = quizRepository.findById(id);
        if (existingQuiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedQuiz.setId(id); // Ensure the ID is set to the correct value
        quizRepository.update(updatedQuiz);
        return new ResponseEntity<>(updatedQuiz, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable("id") int id) {
        Quiz quiz = quizRepository.findById(id);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        quizRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Retrieve all quizzes
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        if (quizzes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }
}
