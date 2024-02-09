package org.example.studentmanagementsystem.repository;

import org.example.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);
    Student findById(int id);
    void update(Student student);
    void delete(int id);

    List<Student> findAll();
}
