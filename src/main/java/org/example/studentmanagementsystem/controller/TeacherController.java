package org.example.studentmanagementsystem.controller;

import org.example.studentmanagementsystem.entity.Teacher;
import org.example.studentmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    // Create
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        teacherRepository.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") int id) {
        Teacher teacher = teacherRepository.findById(id);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") int id, @RequestBody Teacher updatedTeacher) {
        Teacher existingTeacher = teacherRepository.findById(id);
        if (existingTeacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedTeacher.setId(id); // Ensure the ID is set to the correct value
        teacherRepository.update(updatedTeacher);
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("id") int id) {
        Teacher teacher = teacherRepository.findById(id);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teacherRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Retrieve all teachers
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
}
