package it.be.epicode.EsercizioCinque_Progetto.exeptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}