package org.example.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String subject;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Course> courses;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    private List<Quiz> quizzes;

    public Teacher() {
        courses = new ArrayList<>();
    }
}
