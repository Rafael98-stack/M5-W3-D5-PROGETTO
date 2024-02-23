//package it.be.epicode.EsercizioCinque_Progetto.service;
//
//import it.be.epicode.EsercizioCinque_Progetto.entities.Event;
//import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
//import it.be.epicode.EsercizioCinque_Progetto.exceptions.NotFoundException;
//import it.be.epicode.EsercizioCinque_Progetto.repositories.EventDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import java.util.UUID;
//
//public class EventService {
//    @Autowired
//    EventDAO eventDAO;
//
//    public Page<Event> getEventi(int pageNumber, int size, String orderBy) {
//        if (size > 100) size = 100;
//        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
//
//        return eventDAO.findAll(pageable);
//    }
//
//    public Event findById(UUID userId) {
//        return eventDAO.findById(userId).orElseThrow(() -> new NotFoundException(userId));
//    }
//
//    public Event findByIdAndUpdate(UUID userId, Event modifiedUser) {
//        Event found = this.findById(userId);
//        found.setGuest(modifiedUser.getGuest());
//        found.setDate(modifiedUser.getDate());
//        found.setDescription(modifiedUser.getDescription());
//        found.setTitle(modifiedUser.getTitle());
//        found.setLocation(modifiedUser.getLocation());
//        return eventDAO.save(found);
//    }
//}
