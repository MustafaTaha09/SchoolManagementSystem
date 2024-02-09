package org.example.studentmanagementsystem.repository;

import jakarta.persistence.EntityManager;
import org.example.studentmanagementsystem.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@Transactional
public class TeacherRepositoryImpl implements TeacherRepository {

    private EntityManager entityManager;

    @Autowired
    public TeacherRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public Teacher findById(int id) {
        Teacher teacher = entityManager.find(Teacher.class,id);
        return teacher;
    }

    @Override
    public void update(Teacher teacher) {
        entityManager.merge(teacher);
    }

    @Override
    public void delete(int id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        if(teacher == null){
            throw new NoSuchElementException("Teacher of id " + id + " doesn't exist");
        }
        entityManager.remove(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
        return teachers;
    }
}
