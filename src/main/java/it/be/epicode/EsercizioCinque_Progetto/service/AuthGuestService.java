package it.be.epicode.EsercizioCinque_Progetto.service;

import it.be.epicode.EsercizioCinque_Progetto.repositories.GuestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
import it.be.epicode.EsercizioCinque_Progetto.exceptions.BadRequestException;
import it.be.epicode.EsercizioCinque_Progetto.exceptions.UnauthorizedException;
import it.be.epicode.EsercizioCinque_Progetto.payloads.NewGuestDTO;
import it.be.epicode.EsercizioCinque_Progetto.payloads.GuestLoginDTO;
import it.be.epicode.EsercizioCinque_Progetto.security.JWTTools;

@Service
public class AuthGuestService {
    @Autowired
    private GuestService usersService;

    @Autowired
    private PasswordEncoder bcrypt;

    @Autowired
    private GuestDAO guestDAO;
    @Autowired
    private JWTTools jwtTools;

    public String authenticateGuestAndGenerateToken(GuestLoginDTO payload) {
        Guest guest = usersService.findByEmail(payload.email());
        if (bcrypt.matches(payload.password(), guest.getPassword())) {
            return jwtTools.createToken(guest);
        } else {
            throw new UnauthorizedException("Credenziali sbagliate!");
        }
    }

    public Guest saveGuest(NewGuestDTO payload) {
        guestDAO.findByEmail(payload.email()).ifPresent(guest -> {
            throw new BadRequestException("L'email " + guest.getEmail() + " è già in uso!");
        });
        Guest newUser = new Guest(payload.name(), payload.surname(),
                payload.email(), bcrypt.encode(payload.password())
              );

        Guest savedGuest = guestDAO.save(newUser);

        return savedGuest;
    }
}
