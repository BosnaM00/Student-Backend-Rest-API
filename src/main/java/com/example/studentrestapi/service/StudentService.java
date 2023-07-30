package com.example.studentrestapi.service;

import com.example.studentrestapi.exceptions.StudentNotFoundException;
import com.example.studentrestapi.model.Student;
import com.example.studentrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
}
