package org.example.moreeduceorigin.repository;

import org.example.moreeduceorigin.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
