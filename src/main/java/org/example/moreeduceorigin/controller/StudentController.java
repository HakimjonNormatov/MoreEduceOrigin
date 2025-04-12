package org.example.moreeduceorigin.controller;

import org.example.moreeduceorigin.dto.StudentDto;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.model.Students;
import org.example.moreeduceorigin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Students>getALl(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Students getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @PostMapping
    public HttpEntity<?>add(@RequestBody StudentDto studentDto){
        Result student = studentService.createStudent(studentDto);
        return new ResponseEntity<>(student , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?>update(@PathVariable Long id , @RequestBody StudentDto studentDto){
        Result result = studentService.updateStudent(id, studentDto);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?>delete(@PathVariable Long id) {
        Result result = studentService.deleteStudent(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
