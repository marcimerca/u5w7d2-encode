package progettoSettimanale.progettou5w2d5.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import progettoSettimanale.progettou5w2d5.enums.Stato;
import progettoSettimanale.progettou5w2d5.model.Dispositivo;


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
    private String nome;
    private String marca;
    private Stato stato;

   /* public abstract Dispositivo toModel();*/
}
