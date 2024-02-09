package org.example.studentmanagementsystem.repository;

import org.example.studentmanagementsystem.entity.Teacher;

import java.util.List;

public interface TeacherRepository {
    void save(Teacher teacher);
    Teacher findById(int id);
    void update(Teacher teacher);
    void delete(int id);

    List<Teacher> findAll();
}
