package com.students.teachers.compositkey.studentteacherrating.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy="teachers")
    private Set<Student> students;

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherRating> ratings;
}
