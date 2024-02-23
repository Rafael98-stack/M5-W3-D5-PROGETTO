package it.be.epicode.EsercizioCinque_Progetto.controllers;


import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
import it.be.epicode.EsercizioCinque_Progetto.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
import it.be.epicode.EsercizioCinque_Progetto.service.GuestService;

import java.util.UUID;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService usersService;

    @GetMapping
    public Page<Guest> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String orderBy
    ) {
        return this.usersService.getUsers(page, size, orderBy);
    }

    @GetMapping("/me")
    public Guest getProfile(@AuthenticationPrincipal Guest currentAuthenticatedUser) {
        return currentAuthenticatedUser;
    }

    @PutMapping("/me")
    public Guest getMeAndUpdate(@AuthenticationPrincipal Guest currentAuthenticatedUser, @RequestBody Guest updateGuest) {
        return this.usersService.findByIdAndUpdate(currentAuthenticatedUser.getId(), updateGuest);
    }

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getMeAndDelete(@AuthenticationPrincipal Guest currentAuthenticatedGuest) {
        this.usersService.findByIdAndDelete(currentAuthenticatedGuest.getId());
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('MANAGER')")
    public Guest findById(@PathVariable UUID id) {
        return this.usersService.findById(id);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('MANAGER')")
    public Guest findByIdAndUpdate(@PathVariable UUID id, @RequestBody Guest updatedGuest) {

        return this.usersService.findByIdAndUpdate(id, updatedGuest);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('MANAGER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id) {
        this.usersService.findByIdAndDelete(id);
    }

}
