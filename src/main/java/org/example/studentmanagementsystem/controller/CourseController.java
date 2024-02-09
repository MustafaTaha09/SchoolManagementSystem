package org.example.studentmanagementsystem.controller;

import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // Create
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) { // Request entities used to better handle API Requests by manipulating the code request.
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
        Course course = courseRepository.findById(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") int id, @RequestBody Course updatedCourse) {
        Course existingCourse = courseRepository.findById(id);
        if (existingCourse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedCourse.setId(id); // Ensure the ID is set to the correct value
        courseRepository.update(updatedCourse);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") int id) {
        Course course = courseRepository.findById(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        courseRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Retrieve all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) { // Handling DB transaction in case it came back empty.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Better handle the exception with NO_CONTENT for the API request.
        }
        return new ResponseEntity<>(courses, HttpStatus.OK); // Data were retrieved Successfully.
    }
}
