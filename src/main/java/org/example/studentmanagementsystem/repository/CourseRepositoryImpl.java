package org.example.studentmanagementsystem.repository;

import jakarta.persistence.EntityManager;
import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository{
    private EntityManager entityManager;

    @Autowired
    public CourseRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findById(int id) {
        Course course = entityManager.find(Course.class,id);
        return course;
    }

    @Override
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void delete(int id) {
        Course course = entityManager.find(Course.class, id);
        if(course == null){
            throw new NoSuchElementException("course of id " + id + " doesn't exist");
        }
        entityManager.remove(course);
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = entityManager.createQuery("SELECT s FROM Course s", Course.class).getResultList();
        return courses;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
