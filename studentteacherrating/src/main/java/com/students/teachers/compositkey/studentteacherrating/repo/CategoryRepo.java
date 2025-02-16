package com.students.teachers.compositkey.studentteacherrating.repo;

import com.students.teachers.compositkey.studentteacherrating.models.Categorys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Categorys,Long> {
}
