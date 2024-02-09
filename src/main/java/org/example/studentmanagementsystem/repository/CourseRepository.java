package org.example.studentmanagementsystem.repository;

import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.entity.Student;

import java.util.List;

public interface CourseRepository {
    void save(Course course);
    Course findById(int id);
    void update(Course course);
    void delete(int id);
    List<Course> findAll();
}
