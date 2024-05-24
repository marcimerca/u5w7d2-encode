package progettoSettimanale.progettou5w2d5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Table(name = "smartphones")
@Entity
public class Smartphone extends Dispositivo {
    private int memoria;
    private boolean dualSim;
}
