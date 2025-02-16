package com.students.teachers.compositkey.studentteacherrating.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
public class TeacherRating {

    @EmbeddedId
    private TeacherRatingId id;

    @ManyToOne
    @MapsId("studentId") // Maps this field to student_id in composite key
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("teacherId") // Maps this field to teacher_id in composite key
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private int rating;

    public TeacherRating() {
    }

    public TeacherRating(Student student, Teacher teacher, int rating) {
        this.student = student;
        this.teacher = teacher;
        this.rating = rating;
        this.id = new TeacherRatingId(student.getId(), teacher.getId());
    }
}

