package org.example.studentmanagementsystem.controller;

import org.example.studentmanagementsystem.entity.Course;
import org.example.studentmanagementsystem.entity.Student;
import org.example.studentmanagementsystem.repository.CourseRepository;
import org.example.studentmanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Create
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) { // Request entities used to better handle API Requests by manipulating the code request.
        return courseService.save(course);

    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
        return courseService.findById(id);

    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") int id, @RequestBody Course updatedCourse) {
        ResponseEntity<Course> existingCourse = courseService.findById(id);
        if (existingCourse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedCourse.setId(id); // Ensure the ID is set to the correct value
        courseService.update(updatedCourse);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") int id) {
        return courseService.delete(id);

    }

    // Retrieve all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return courseService.findAll();

    }
}
