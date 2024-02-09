package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.entity.Student;
import org.example.studentmanagementsystem.entity.Teacher;
import org.example.studentmanagementsystem.repository.StudentRepository;
import org.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public Student findById(int id){
        Student student = studentRepository.findById(id);
        if(student == null){
            throw new NullPointerException("student of id " + id + " doesn't exist");
        }
        return student;

    }

    public void delete(int id){
        studentRepository.delete(id);
    }

    public List<Student> findAll(){
        List<Student> students = studentRepository.findAll();
        if(students == null)
            throw new NullPointerException("List of teachers is empty and currently NULL");
        return students;
    }

    public void update(Student student){
        studentRepository.update(student);
    }
}
