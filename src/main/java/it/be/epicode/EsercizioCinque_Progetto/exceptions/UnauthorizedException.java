package it.be.epicode.EsercizioCinque_Progetto.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}