package org.example.studentmanagementsystem.repository;

import jakarta.persistence.EntityManager;
import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@Transactional
public class QuizRepositoryImpl implements QuizRepository{

    private EntityManager entityManager;

    @Autowired
    public QuizRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(Quiz quiz) {
        entityManager.persist(quiz);
    }

    @Override
    public Quiz findById(int id) {
        Quiz quiz = entityManager.find(Quiz.class,id);
        return quiz;
    }

    @Override
    public void update(Quiz quiz) {
        entityManager.merge(quiz);
    }

    @Override
    public void delete(int id) {
        Quiz quiz = entityManager.find(Quiz.class, id);
        if(quiz == null){
            throw new NoSuchElementException("quiz of id " + id + " doesn't exist");
        }
        entityManager.remove(quiz);
    }

    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizzes = entityManager.createQuery("SELECT q FROM Quiz q", Quiz.class).getResultList();
        return quizzes;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
