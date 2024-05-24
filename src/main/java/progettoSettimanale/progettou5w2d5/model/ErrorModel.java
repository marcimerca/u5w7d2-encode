package progettoSettimanale.progettou5w2d5.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorModel {
    private String messaggio;
    private LocalDateTime dataErrore;
}
