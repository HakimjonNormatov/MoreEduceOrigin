package org.example.moreeduceorigin.controller;

import org.example.moreeduceorigin.dto.VideoDto;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.model.Video;
import org.example.moreeduceorigin.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/{id}")
    public Video getById(Integer id) {
        return videoService.getById(id);
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody VideoDto videoDto) {
        Result video = videoService.create(videoDto);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@RequestBody VideoDto videoDto, @PathVariable Integer id) {
        Result video = videoService.update(videoDto, id);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result video = videoService.delete(id);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }
}
