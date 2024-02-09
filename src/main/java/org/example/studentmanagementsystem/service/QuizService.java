package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.entity.Quiz;
import org.example.studentmanagementsystem.repository.CourseRepository;
import org.example.studentmanagementsystem.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuizService {

    private QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }

    public void save(Quiz quiz){
        quizRepository.save(quiz);
    }

    public Quiz findById(int id){
        Quiz quiz = quizRepository.findById(id);
        if(quiz == null){
            throw new NullPointerException("Quiz of id " + id + " doesn't exist");
        }
        return quiz;

    }

    public void delete(int id){
        quizRepository.delete(id);
    }

    public List<Quiz> findAll(){
        List<Quiz> quizzes = quizRepository.findAll();
        if(quizzes == null)
            throw new NullPointerException("List of quizzes is empty and currently NULL");
        return quizzes;
    }

    public void update(Quiz quiz){
        quizRepository.update(quiz);
    }
}
