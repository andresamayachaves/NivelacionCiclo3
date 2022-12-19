package org.reto3.repositories;

import org.reto3.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Integer> {
}
