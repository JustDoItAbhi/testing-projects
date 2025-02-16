package com.students.teachers.compositkey.studentteacherrating.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeacherRatingId implements Serializable {
    private Long studentId;
    private Long teacherId;

    public TeacherRatingId() {
    }

    public TeacherRatingId(Long studentId, Long teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherRatingId that = (TeacherRatingId) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(teacherId, that.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, teacherId);
    }
}
