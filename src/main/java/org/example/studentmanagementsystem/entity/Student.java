package org.example.studentmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String collegeId;
    private double gpa;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // Certain cascade types implemented based on my understanding of the project logic
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // Certain cascade types implemented based on my understanding of the project logic
    @JoinTable(name = "student_quiz",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private List<Quiz> quizzes;

    public Student() {
        courses = new ArrayList<>();
        quizzes = new ArrayList<>();
    }


}
