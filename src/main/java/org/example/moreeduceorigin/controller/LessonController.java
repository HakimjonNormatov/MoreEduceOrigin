package org.example.moreeduceorigin.controller;

import org.example.moreeduceorigin.dto.LessonDto;
import org.example.moreeduceorigin.dto.StudentDto;
import org.example.moreeduceorigin.model.Lesson;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.model.Students;
import org.example.moreeduceorigin.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lesson")
public class LessonController {

    @Autowired
    LessonService lessonService;

    @GetMapping
    public List<Lesson> getALl(){
        return lessonService.getAll();
    }

    @GetMapping("/{id}")
    public Lesson getById(Long id){
        return lessonService.getById(id);
    }

    @PostMapping
    public HttpEntity<?> add(LessonDto lessonDto){
        Result student = lessonService.create(lessonDto);
        return new ResponseEntity<>(student , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?>update(Long id , LessonDto lessonDto){
        Result result = lessonService.update(lessonDto , id);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?>delete(Long id) {
        Result result = lessonService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
