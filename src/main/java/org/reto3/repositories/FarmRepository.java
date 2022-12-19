package org.reto3.repositories;

import org.reto3.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository  extends JpaRepository<Farm, Integer> {
}
