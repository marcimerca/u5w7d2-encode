package progettoSettimanale.progettou5w2d5.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import progettoSettimanale.progettou5w2d5.enums.Stato;
import progettoSettimanale.progettou5w2d5.model.Dispositivo;

//NB: durante la post e la put, è necessario (ad esempio su Postman) aggiungere "type": "smartphone" o "type": "computer" per indicare il tipo di dispositivo

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ComputerDto.class, name = "computer"),
        @JsonSubTypes.Type(value = SmartphoneDto.class, name = "smartphone")
})
@Data
public abstract class DispositivoDto {
    @NotBlank(message = "Il nome non può essere null, e non può essere vuoto o composto solo da spazi")
    private String nome;
    @NotBlank(message = "La marca non può essere null, e non può essere vuota o composto solo da spazi")
    private String marca;
    @NotNull(message = "Lo stato non può essere nullo e può solo assumere i seguenti valori: DISPONIBILE,ASSEGNATO,IN_MANUTENZIONE,DISMESSO")
    @Enumerated(EnumType.STRING)
    private Stato stato;

}
