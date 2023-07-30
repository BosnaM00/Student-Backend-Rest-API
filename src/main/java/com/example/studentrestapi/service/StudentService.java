package com.example.studentrestapi.service;

import com.example.studentrestapi.exceptions.StudentNotFoundException;
import com.example.studentrestapi.model.Student;
import com.example.studentrestapi.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final EntityManager entityManager;

    @Autowired
    public StudentService(StudentRepository studentRepository, EntityManager entityManager) {
        this.studentRepository = studentRepository;
        this.entityManager = entityManager;
    }


    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student by id " + id + " was not found"));
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public List<Student> findAllByFirstName(){
        return studentRepository.findAllByOrderByFirstName();
    }

    public List<Student> findAllByFirstNameEm() {
        String jpql = "SELECT s FROM Student s WHERE s.firstName IS NOT NULL ORDER BY s.firstName ASC";
        Query jpqlQuery = entityManager.createQuery(jpql, Student.class);
        List<Student> resultList = jpqlQuery.getResultList();
        return resultList;
    }

    public List<Student> findAllOrderByLastNameDesc(){
        return studentRepository.findAllStudentsOrderByLastNameDesc();
    }

    public List<Student> findAllOrderByLastNameDescEm() {
        String jpqlQuery = "SELECT s FROM Student s WHERE s.firstName IS NOT NULL ORDER BY s.lastName DESC";
        TypedQuery<Student> query = entityManager.createQuery(jpqlQuery, Student.class);
        return query.getResultList();
    }
}
