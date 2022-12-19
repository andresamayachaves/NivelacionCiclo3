package org.reto3.repositories;

import org.reto3.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {
}
