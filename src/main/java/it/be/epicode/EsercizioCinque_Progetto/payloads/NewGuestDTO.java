package it.be.epicode.EsercizioCinque_Progetto.payloads;

public record NewGuestDTO(
        String name,
        String surname,
        String email,
        String password) {
}
