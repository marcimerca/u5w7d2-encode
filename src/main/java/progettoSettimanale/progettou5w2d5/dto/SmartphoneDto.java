package progettoSettimanale.progettou5w2d5.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import progettoSettimanale.progettou5w2d5.model.Dispositivo;
import progettoSettimanale.progettou5w2d5.model.Smartphone;

@Data
public class SmartphoneDto extends DispositivoDto {
    @NotNull
    @Positive(message = "La memoria non può essere null, e deve avere valore maggiore di zero")
    private int memoria;
    @NotNull(message = "il campo dualSim non può essere nullo e deve essere un valore booleano(true o false")
    private boolean dualSim;

  /*  @Override
    public Dispositivo toModel() {
        Smartphone smartphone = new Smartphone();
        smartphone.setNome(getNome());
        smartphone.setMarca(getMarca());
        smartphone.setStato(getStato());
        smartphone.setMemoria(getMemoria());
        smartphone.setDualSim(isDualSim());
        return smartphone;
    }*/
}
