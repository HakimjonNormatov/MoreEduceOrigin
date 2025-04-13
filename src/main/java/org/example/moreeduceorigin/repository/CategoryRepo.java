package org.example.moreeduceorigin.repository;

import org.example.moreeduceorigin.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category , Long> {
}
