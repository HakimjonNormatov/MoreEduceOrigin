package org.example.moreeduceorigin.repository;

import jakarta.validation.constraints.Email;
import org.example.moreeduceorigin.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository<Lesson , Long> {
    boolean existsByEmailAndUsername( String name);
}
