package org.example.studentmanagementsystem.repository;

import jakarta.persistence.EntityManager;
import org.example.studentmanagementsystem.entity.Quiz;
import org.example.studentmanagementsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository{
    private EntityManager entityManager;

    @Autowired
    public StudentRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class,id);
        return student;
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        if(student == null){
            throw new NoSuchElementException("Student of id " + id + " doesn't exist");
        }
        entityManager.remove(student);
    }
    @Override
    public List<Student> findAll() {
        List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        return students;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
