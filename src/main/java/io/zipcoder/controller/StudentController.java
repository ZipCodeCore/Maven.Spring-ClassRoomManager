package io.zipcoder.controller;

import io.zipcoder.domain.Student;
import io.zipcoder.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value="/students", method= RequestMethod.GET)
    public ResponseEntity<?> getAllStudents(){
        Iterable<Student> allStudents = studentRepository.findAll();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @RequestMapping(value="/student", method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(){
        Student student = new Student();
        student.setFirstName("Chuck");
        student.setId(22l);
        student = studentRepository.save(student);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/students").buildAndExpand(student.getId()).toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
