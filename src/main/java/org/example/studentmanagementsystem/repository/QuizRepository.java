package org.example.studentmanagementsystem.repository;

import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.entity.Quiz;

import java.util.List;

public interface QuizRepository {
    void save(Quiz quiz);
    Quiz findById(int id);
    void update(Quiz quiz);
    void delete(int id);

    List<Quiz> findAll();
}
