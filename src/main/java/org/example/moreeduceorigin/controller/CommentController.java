package org.example.moreeduceorigin.controller;

import org.example.moreeduceorigin.dto.CommentDto;
import org.example.moreeduceorigin.model.Comment;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/{id}")
    public Comment getById(Long id){
        return commentService.getById(id);
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody CommentDto commentDto){
        Result comment= commentService.create(commentDto);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@RequestBody CommentDto commentDto, @PathVariable Long id){
        Result comment= commentService.update(id , commentDto);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        Result comment= commentService.delete(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
