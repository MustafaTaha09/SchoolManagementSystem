package org.example.studentmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String code;

    @ManyToMany(mappedBy = "courses", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonIgnore
    private List<Student> students;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
    private List<Quiz> quizzes;


    public Course() {
        students = new ArrayList<>();
        quizzes = new ArrayList<>();

    }

}
