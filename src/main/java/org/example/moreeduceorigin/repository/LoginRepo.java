package org.example.moreeduceorigin.repository;

import org.example.moreeduceorigin.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login , Long> {
    boolean existsByEmailAndPassword(String email, String password);
}
