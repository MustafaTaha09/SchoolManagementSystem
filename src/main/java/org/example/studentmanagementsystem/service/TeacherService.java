package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.entity.Quiz;
import org.example.studentmanagementsystem.entity.Student;
import org.example.studentmanagementsystem.entity.Teacher;
import org.example.studentmanagementsystem.repository.QuizRepository;
import org.example.studentmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public ResponseEntity<Teacher> save(Teacher teacher){
        teacherRepository.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    public ResponseEntity<Teacher> findById(int id){
        Teacher teacher = teacherRepository.findById(id);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);

    }

    public ResponseEntity<Void> delete(int id){
        if(teacherRepository.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        teacherRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Teacher>> findAll(){
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    public void update(Teacher teacher){
        teacherRepository.update(teacher);
    }
}
