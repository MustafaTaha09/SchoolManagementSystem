package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.entity.Student;
import org.example.studentmanagementsystem.entity.Teacher;
import org.example.studentmanagementsystem.repository.StudentRepository;
import org.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<Student> save(Student student){
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    public ResponseEntity<Student> findById(int id){
        Student student = studentRepository.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    public ResponseEntity<Void> delete(int id){
       if(studentRepository.findById(id) == null)
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        studentRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    public void update(Student student){
        studentRepository.update(student);
    }
}
