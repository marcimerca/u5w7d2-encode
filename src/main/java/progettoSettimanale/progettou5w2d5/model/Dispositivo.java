package progettoSettimanale.progettou5w2d5.model;

import jakarta.persistence.*;
import lombok.Data;
import progettoSettimanale.progettou5w2d5.enums.Stato;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dispositivo {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String marca;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;
}
