package progettoSettimanale.progettou5w2d5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "computers")
public class Computer extends Dispositivo {
    public int ram;
    public int monitor;
}
