package it.be.epicode.EsercizioCinque_Progetto.repositories;

import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GuestDAO extends JpaRepository<Guest, UUID> {
    Optional<Guest> findByEmail(String email);
}
