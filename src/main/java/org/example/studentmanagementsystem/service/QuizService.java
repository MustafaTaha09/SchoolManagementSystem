package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.entity.Quiz;
import org.example.studentmanagementsystem.entity.Student;
import org.example.studentmanagementsystem.repository.CourseRepository;
import org.example.studentmanagementsystem.repository.QuizRepository;
import org.example.studentmanagementsystem.repository.QuizRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuizService {

    private QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }

    public ResponseEntity<Quiz> save(Quiz quiz){
        quizRepository.save(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }

    public ResponseEntity<Quiz> findById(int id){
        Quiz quiz = quizRepository.findById(id);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quiz, HttpStatus.OK);

    }

    public ResponseEntity<Void> delete(int id){
        if(quizRepository.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        quizRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Quiz>> findAll(){
        List<Quiz> quizzes = quizRepository.findAll();
        if (quizzes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    public void update(Quiz quiz){
        quizRepository.update(quiz);
    }

    public void setQuizRepository(QuizRepositoryImpl quizRepository) {
        this.quizRepository = quizRepository;
    }
}
