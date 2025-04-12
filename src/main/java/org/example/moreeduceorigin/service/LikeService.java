package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.dto.LikeDto;
import org.example.moreeduceorigin.model.Like;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.repository.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    LikeRepo likeRepo;

    public List<Like> getAll(){
        return likeRepo.findAll();
    }

    public Like getById(Long id){
        return likeRepo.findById(id).get();
    }

    public Result create(LikeDto likeDto){
        Like like = new Like();
        like.setCount(likeDto.getCount());
        likeRepo.save(like);
        return new Result(true , "❤️");
    }

    public Result deleteLike(Long id){
        likeRepo.deleteById(id);
        return new Result(true , " ochirildi");
    }

}
