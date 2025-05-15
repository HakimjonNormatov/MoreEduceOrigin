package org.example.moreeduceorigin.controller;

import org.example.moreeduceorigin.dto.LikeDto;
import org.example.moreeduceorigin.model.Like;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @GetMapping
    public List<Like> getAll() {
        return likeService.getAll();
    }

    @GetMapping("/{id}")
    public Like getById(@PathVariable Long id) {
        return likeService.getById(id);
    }

    @PostMapping
    public HttpEntity<?> createLike(@RequestBody LikeDto likeDto) {
        Result result = likeService.create(likeDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteLike(@PathVariable Long id) {
        Result result = likeService.deleteLike(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
