package org.example.moreeduceorigin.repository;

import org.example.moreeduceorigin.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test , Long> {
}
