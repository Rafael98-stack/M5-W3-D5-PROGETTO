package it.be.epicode.EsercizioCinque_Progetto.exeptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorsPayload {
    // Questa classe rappresenta il payload delle risposte di errore
    private String message;
    private LocalDateTime timestamp;
}
