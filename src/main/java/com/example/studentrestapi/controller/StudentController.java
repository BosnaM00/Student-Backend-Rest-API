package com.example.studentrestapi.controller;

import com.example.studentrestapi.model.Student;
import com.example.studentrestapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents () {
        return studentService.findAllStudents();
    }

    @GetMapping("/find/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/all/firstNameAsc")
    public List<Student> getAllAppUserByFirstName(){
        return studentService.findAllByFirstName();
    }

    @GetMapping("/all/firstNameAsc/em")
    public List<Student> getAllAppUserByFirstNameEm(){
        return studentService.findAllByFirstNameEm();
    }

    @GetMapping("/all/lastNameDesc")
    public List<Student> getAllAppUserByLastNameDesc(){
        return studentService.findAllOrderByLastNameDesc();
    }

    @GetMapping("/all/lastNameDesc/em")
    public List<Student> getAllAppUserByLastNameDescEm(){
        return studentService.findAllOrderByLastNameDescEm();
    }

}
