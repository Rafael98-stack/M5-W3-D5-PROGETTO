package it.be.epicode.EsercizioCinque_Progetto.service;

import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
import it.be.epicode.EsercizioCinque_Progetto.entities.Manager;
import it.be.epicode.EsercizioCinque_Progetto.repositories.GuestDAO;
import it.be.epicode.EsercizioCinque_Progetto.repositories.ManagerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
import it.be.epicode.EsercizioCinque_Progetto.exceptions.NotFoundException;
import it.be.epicode.EsercizioCinque_Progetto.repositories.GuestDAO;

import java.util.UUID;

@Service
public class ManagerService {
    @Autowired
    private ManagerDAO managerDAO;


    public Page<Manager> getUsers(int pageNumber, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));

        return managerDAO.findAll(pageable);
    }


    public Manager findById(UUID userId) {
        return managerDAO.findById(userId).orElseThrow(() -> new NotFoundException(userId));
    }

    public Manager findByIdAndUpdate(UUID userId, Guest modifiedUser) {
        Manager found = this.findById(userId);
        found.setSurname(modifiedUser.getSurname());
        found.setName(modifiedUser.getName());
        found.setEmail(modifiedUser.getEmail());
        found.setPassword(modifiedUser.getPassword());
        return managerDAO.save(found);
    }

    public void findByIdAndDelete(UUID userId) {
        Manager found = this.findById(userId);
        managerDAO.delete(found);
    }

    public Manager findByEmail(String email) {
        return managerDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("Email " + email + " non trovata"));
    }


}

