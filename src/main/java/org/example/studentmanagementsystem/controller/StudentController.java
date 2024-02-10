package org.example.studentmanagementsystem.controller;

import org.example.studentmanagementsystem.entity.Student;
import org.example.studentmanagementsystem.repository.StudentRepository;
import org.example.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return studentService.save(student);

    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        return studentService.findById(id);

    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student updatedStudent) {
        ResponseEntity<Student> existingStudent = studentService.findById(id);
        if (existingStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedStudent.setId(id); // Ensure the ID is set to the correct value
        studentService.update(updatedStudent);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
        return studentService.delete(id);
    }

    // Retrieve all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return studentService.findAll();
    }
}

