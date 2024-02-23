package it.be.epicode.EsercizioCinque_Progetto.repositories;

import it.be.epicode.EsercizioCinque_Progetto.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManagerDAO extends JpaRepository<Manager, UUID> {
    Optional<Manager> findByEmail(String email);
}
