package progettoSettimanale.progettou5w2d5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import progettoSettimanale.progettou5w2d5.dto.DipendenteDto;
import progettoSettimanale.progettou5w2d5.exception.DipendenteNonTrovatoException;
import progettoSettimanale.progettou5w2d5.model.Dipendente;
import progettoSettimanale.progettou5w2d5.service.DipendenteService;

import java.util.List;
import java.util.Optional;

@RestController
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/dipendenti")
    public String saveDipendente( @RequestBody DipendenteDto dipendenteDto){
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    @GetMapping("/dipendenti")
    public List<Dipendente> getAllDipendenti(){
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/dipendenti/{id}")
    public Dipendente getDipendenteById( @PathVariable int id){
        Optional<Dipendente> dipendenteOptional = dipendenteService.getDipendenteById(id);
        if(dipendenteOptional.isPresent()){
            Dipendente dipendente = dipendenteOptional.get();
            return dipendente;

        } else {
            throw new DipendenteNonTrovatoException("Il dipendente con id " + id + " non è stato trovato.");
        }
    }

    @PutMapping("/dipendenti/{id}")
    public Dipendente updateDipendente( @PathVariable int id, @RequestBody DipendenteDto dipendenteDto){
        return dipendenteService.updateDipendente(id,dipendenteDto);
    }

    @DeleteMapping("/dipendenti/{id}")
    public String deleteDipendente(@PathVariable int id){
        return dipendenteService.deleteDipendente(id);
    }
}
