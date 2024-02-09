package org.example.studentmanagementsystem.service;

import jakarta.persistence.EntityManager;
import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.entity.Student;
import org.example.studentmanagementsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public void save(Course course){
        courseRepository.save(course);
    }

    public Course findById(int id){
        Course course = courseRepository.findById(id);
        if(course == null){
            throw new NullPointerException("course of id " + id + " doesn't exist");
        }
        return course;

    }

    public void delete(int id){
        courseRepository.delete(id);
    }

    public List<Course> findAll(){
        List<Course> courses = courseRepository.findAll();
        if(courses == null)
            throw new NullPointerException("List of students is empty and currently NULL");
        return courses;
    }

    public void update(Course course){
        courseRepository.update(course);
    }
}
