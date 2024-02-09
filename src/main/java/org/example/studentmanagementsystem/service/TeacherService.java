package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.entity.Quiz;
import org.example.studentmanagementsystem.entity.Teacher;
import org.example.studentmanagementsystem.repository.QuizRepository;
import org.example.studentmanagementsystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public void save(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public Teacher findById(int id){
        Teacher teacher = teacherRepository.findById(id);
        if(teacher == null){
            throw new NullPointerException("teacher of id " + id + " doesn't exist");
        }
        return teacher;

    }

    public void delete(int id){
        teacherRepository.delete(id);
    }

    public List<Teacher> findAll(){
        List<Teacher> teachers = teacherRepository.findAll();
        if(teachers == null)
            throw new NullPointerException("List of teachers is empty and currently NULL");
        return teachers;
    }

    public void update(Teacher teacher){
        teacherRepository.update(teacher);
    }
}
