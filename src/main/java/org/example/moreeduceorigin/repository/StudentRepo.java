package org.example.moreeduceorigin.repository;

import jakarta.validation.constraints.Email;
import org.example.moreeduceorigin.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students , Long> {
    boolean existsByEmailAndUsername(@Email String email, String username);
}
