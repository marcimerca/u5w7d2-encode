package progettoSettimanale.progettou5w2d5.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import progettoSettimanale.progettou5w2d5.model.Computer;
import progettoSettimanale.progettou5w2d5.model.Dispositivo;

@Data
public class ComputerDto extends DispositivoDto {
    public int ram;
    public int monitor;

 /*   @Override
    public Dispositivo toModel() {
        Computer computer = new Computer();
        computer.setNome(getNome());
        computer.setMarca(getMarca());
        computer.setStato(getStato());
        computer.setRam(getRam());
        computer.setMonitor(getMonitor());
        return computer;
    }*/
}
