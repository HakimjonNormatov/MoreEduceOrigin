package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.dto.CommentDto;
import org.example.moreeduceorigin.model.Comment;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;

    public List<Comment> getAll() {
        return commentRepo.findAll();
    }
    public Comment getById(Integer id) {
        return commentRepo.findById(id).get();
    }
    public Result create(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setComment(commentDto.getComment());
        comment.setEmail(commentDto.getEmail());
        comment.setLike_id(commentDto.getLike_id());
        commentRepo.save(comment);
    return new Result(true, "Comment created");
    }
    public Result update(CommentDto commentDto, Integer id) {
        Comment comment = commentRepo.findById(id).get();
        comment.setName(commentDto.getName());
        comment.setComment(commentDto.getComment());
        comment.setEmail(commentDto.getEmail());
        comment.setLike_id(commentDto.getLike_id());
        commentRepo.save(comment);
        return new Result(true, "Comment updated");
    }
    public Result delete(Integer id) {
        Comment comment = commentRepo.findById(id).get();
        commentRepo.delete(comment);
        return new Result(true, "Comment deleted");
    }
}
