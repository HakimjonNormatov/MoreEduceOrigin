package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.dto.VideoDto;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.model.Test;
import org.example.moreeduceorigin.model.Video;
import org.example.moreeduceorigin.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    VideoRepo videoRepo;

    public List<Video> getAll() {
        return videoRepo.findAll();
    }
    public Video getById(Long id) {
        return videoRepo.findById(id).get();
    }
    public Result create(VideoDto videoDto) {
        Video video = new Video();
        video.setName(videoDto.getName());
        video.setDuration(videoDto.getDuration());
        video.setSize(videoDto.getSize());
        video.setPath(videoDto.getPath());

        videoRepo.save(video);
        return new Result(true, "Video created successfully");
    }
    public Result update(VideoDto videoDto, Long id) {
        Video video = videoRepo.findById(id).get();
        video.setName(videoDto.getName());
        video.setDuration(videoDto.getDuration());
        video.setSize(videoDto.getSize());
        video.setPath(videoDto.getPath());
        videoRepo.save(video);
        return new Result(true, "Video updated successfully");
    }


    public Result delete(Long id) {
        Video video = videoRepo.findById(id).get();
        videoRepo.delete(video);
        return new Result(true, "Video deleted successfully");
    }

}
