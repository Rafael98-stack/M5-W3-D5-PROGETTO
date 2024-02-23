package it.be.epicode.EsercizioCinque_Progetto.service;


import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
import it.be.epicode.EsercizioCinque_Progetto.repositories.GuestDAO;
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
public class GuestService {
    @Autowired
    private GuestDAO usersDAO;


    public Page<Guest> getUsers(int pageNumber, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));

        return usersDAO.findAll(pageable);
    }


    public Guest findById(UUID userId) {
        return usersDAO.findById(userId).orElseThrow(() -> new NotFoundException(userId));
    }

    public Guest findByIdAndUpdate(UUID userId, Guest modifiedUser) {
        Guest found = this.findById(userId);
        found.setSurname(modifiedUser.getSurname());
        found.setName(modifiedUser.getName());
        found.setEmail(modifiedUser.getEmail());
        found.setPassword(modifiedUser.getPassword());
        return usersDAO.save(found);
    }

    public void findByIdAndDelete(UUID userId) {
        Guest found = this.findById(userId);
        usersDAO.delete(found);
    }

    public Guest findByEmail(String email) {
        return usersDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("Email " + email + " non trovata"));
    }


}
