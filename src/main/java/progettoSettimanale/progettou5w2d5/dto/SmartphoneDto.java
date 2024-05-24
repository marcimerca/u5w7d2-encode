package progettoSettimanale.progettou5w2d5.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import progettoSettimanale.progettou5w2d5.model.Dispositivo;
import progettoSettimanale.progettou5w2d5.model.Smartphone;

@Data
public class SmartphoneDto extends DispositivoDto {
    private int memoria;
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
