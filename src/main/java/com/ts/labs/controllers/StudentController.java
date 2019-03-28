package com.ts.labs.controllers;

import com.ts.labs.commons.Response;
import com.ts.labs.exceptions.NoSuchStudentException;
import com.ts.labs.pojo.Student;
import com.ts.labs.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    StudentService service;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getStudents(){

        return new ResponseEntity<>(service.getStudents(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Student> getStudent(@RequestParam int id) throws Exception {
        return new ResponseEntity<>(service.getStudent(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student){
        service.addStudent(student);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Response> modifyStudent(@RequestParam int id , @RequestBody Student st) throws NoSuchStudentException {
        service.modifyStudent(id,st);
        return new ResponseEntity<>(new Response("user was modified"),HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity<Response> deleteStudent(@RequestParam int id) throws NoSuchStudentException {
        service.removeStudent(id);
        return new ResponseEntity<>(new Response("user was deleted"),HttpStatus.OK);
    }

}
