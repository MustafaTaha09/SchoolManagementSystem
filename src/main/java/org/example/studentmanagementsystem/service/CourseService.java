package org.example.studentmanagementsystem.service;

import jakarta.persistence.EntityManager;
import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.entity.Student;
import org.example.studentmanagementsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<Course> save(Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    public ResponseEntity<Course> findById(int id){
        Course course = courseRepository.findById(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);

    }

    public ResponseEntity<Void> delete(int id){
        if(courseRepository.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        courseRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Course>> findAll(){
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    public void update(Course course){
        courseRepository.update(course);
    }
}
