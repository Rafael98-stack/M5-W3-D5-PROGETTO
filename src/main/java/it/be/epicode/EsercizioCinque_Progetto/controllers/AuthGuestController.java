package it.be.epicode.EsercizioCinque_Progetto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
import it.be.epicode.EsercizioCinque_Progetto.payloads.LoginResponseDTO;
import it.be.epicode.EsercizioCinque_Progetto.payloads.NewGuestDTO;
import it.be.epicode.EsercizioCinque_Progetto.payloads.GuestLoginDTO;
import it.be.epicode.EsercizioCinque_Progetto.service.AuthGuestService;

@RestController
@RequestMapping("/auth")
public class AuthGuestController {
    @Autowired
    private AuthGuestService authGuestService;


    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody GuestLoginDTO payload) {
        return new LoginResponseDTO(authGuestService.authenticateGuestAndGenerateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Guest saveGuest(@RequestBody NewGuestDTO newGuest) {

        return this.authGuestService.saveGuest(newGuest);
    }
}
