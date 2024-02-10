package org.example.studentmanagementsystem.controller;

import org.example.studentmanagementsystem.entity.Teacher;
import org.example.studentmanagementsystem.repository.TeacherRepository;
import org.example.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // Create
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") int id) {
        return teacherService.findById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") int id, @RequestBody Teacher updatedTeacher) {
        ResponseEntity<Teacher> existingTeacher = teacherService.findById(id);
        if (existingTeacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedTeacher.setId(id); // Ensure the ID is set to the correct value
        teacherService.update(updatedTeacher);
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("id") int id) {
        return teacherService.delete(id);
    }

    // Retrieve all teachers
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return teacherService.findAll();
    }
}
