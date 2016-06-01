package io.zipcoder.controller;

import io.zipcoder.domain.Student;
import io.zipcoder.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value="/students", method= RequestMethod.GET)
    public ResponseEntity<?> getAllStudents(){
        Iterable<Student> allStudents = studentRepository.findAll();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

}
