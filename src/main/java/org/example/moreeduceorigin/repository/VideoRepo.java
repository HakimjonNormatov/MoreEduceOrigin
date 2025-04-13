package org.example.moreeduceorigin.repository;

import org.example.moreeduceorigin.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, Integer> {
}
