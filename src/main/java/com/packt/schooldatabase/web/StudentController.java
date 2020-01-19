package com.packt.schooldatabase.web;

import com.packt.schooldatabase.domain.Student;
import com.packt.schooldatabase.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
@Autowired
    private StudentRepository repository;
    @RequestMapping("/students")
    public Iterable<Student> getStudents(){
        return repository.findAll();
    }
}
