package org.example.moreeduceorigin.controller;

import org.example.moreeduceorigin.dto.TestDto;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.model.Test;
import org.example.moreeduceorigin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/{id}")
    public Test getById(Long id) {
        return testService.getById(id);
    }

    @PostMapping
    public HttpEntity<?> add(TestDto testDto) {
        Result student = testService.create(testDto);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(Long id, TestDto testDto) {
        Result result = testService.update(testDto, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(Long id) {
        Result result = testService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
