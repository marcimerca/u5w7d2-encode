package progettoSettimanale.progettou5w2d5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettoSettimanale.progettou5w2d5.dto.DipendenteDto;
import progettoSettimanale.progettou5w2d5.exception.DipendenteNonTrovatoException;
import progettoSettimanale.progettou5w2d5.model.Dipendente;
import progettoSettimanale.progettou5w2d5.repository.DipendenteRepository;
import progettoSettimanale.progettou5w2d5.repository.DispositivoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public String saveDipendente(DipendenteDto dipendenteDto) {
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setEmail(dipendenteDto.getEmail());
        dipendente.setUsername(dipendenteDto.getEmail());
        dipendenteRepository.save(dipendente);
        return "Dipendente con username " + dipendenteDto.getUsername() + " è stato salvato con successo";
    }

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Optional<Dipendente> getDipendenteById(int id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto) {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);
        if (dipendenteOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome(dipendenteDto.getCognome());
            dipendente.setUsername(dipendenteDto.getUsername());
            dipendente.setEmail(dipendenteDto.getEmail());
            dipendenteRepository.save(dipendente);
            return dipendente;
        } else {
            throw new DipendenteNonTrovatoException("Il dipendente con id " + id + " non è stato trovato");
        }
    }

    public String deleteDipendente(int id) {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);
        if (dipendenteOptional.isPresent()) {

            dipendenteRepository.delete(dipendenteOptional.get());
            return "Il dipendente con id " + id + " è stato eliminato con successo.";
        } else {
            throw new DipendenteNonTrovatoException("Il dipendente con id " + id + " non è stato trovato");
        }


    }
}
