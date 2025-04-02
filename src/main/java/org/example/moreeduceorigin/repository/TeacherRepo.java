package org.example.moreeduceorigin.repository;

import jakarta.validation.constraints.Email;
import org.example.moreeduceorigin.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher , Long> {

    boolean existsByEmailAndUsername(@Email String email, String username);

}
