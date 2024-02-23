package it.be.epicode.EsercizioCinque_Progetto.repositories;

import it.be.epicode.EsercizioCinque_Progetto.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventDAO extends JpaRepository<Event, UUID> {
    Optional<Event> findByTitle(String email);
}
