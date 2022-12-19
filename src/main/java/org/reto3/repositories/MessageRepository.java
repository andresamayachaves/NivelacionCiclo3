package org.reto3.repositories;

import org.reto3.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message, Integer> {
}
