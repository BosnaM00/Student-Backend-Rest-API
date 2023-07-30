package com.example.studentrestapi.repository;

import com.example.studentrestapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentById(Long id);
    List<Student> findAllByOrderByFirstName();

    @Query("SELECT s FROM Student s WHERE s.firstName IS NOT NULL ORDER BY s.lastName DESC")
    List<Student> findAllStudentsOrderByLastNameDesc();

}
