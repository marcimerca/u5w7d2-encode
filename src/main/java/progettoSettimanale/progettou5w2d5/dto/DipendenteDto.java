package progettoSettimanale.progettou5w2d5.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DipendenteDto {

    @NotBlank(message = "Lo username non può essere null, e non può essere vuoto o composto solo da spazi")
    private String username;
    @NotBlank(message = "Il nome non può essere null, e non può essere vuoto o composto solo da spazi")
    private String nome;
    @NotBlank(message = "Il cognome non può essere null, e non può essere vuoto o composto solo da spazi")
    private String cognome;
    @Email
    @NotBlank(message = "L' email non può essere null, e non può essere vuota o composta solo da spazi")
    private String email;
}
