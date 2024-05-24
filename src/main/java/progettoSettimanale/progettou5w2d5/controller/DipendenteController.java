package progettoSettimanale.progettou5w2d5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import progettoSettimanale.progettou5w2d5.dto.DipendenteDto;
import progettoSettimanale.progettou5w2d5.exception.DipendenteNonTrovatoException;
import progettoSettimanale.progettou5w2d5.exception.MyBadRequestException;
import progettoSettimanale.progettou5w2d5.model.Dipendente;
import progettoSettimanale.progettou5w2d5.service.DipendenteService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;



    @PostMapping("/dipendenti")
    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           throw new MyBadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(s1,s2)->s1+s2));
       }
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
    public Dipendente updateDipendente( @PathVariable int id, @RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new MyBadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(s1,s2)->s1+s2));
        }

        return dipendenteService.updateDipendente(id,dipendenteDto);
    }

    @DeleteMapping("/dipendenti/{id}")
    public String deleteDipendente(@PathVariable int id){
        return dipendenteService.deleteDipendente(id);
    }

    @PatchMapping("/dipendenti/{id}")
    public String patchFotoDipendente( @PathVariable int id, @RequestBody MultipartFile foto) throws IOException {
        return dipendenteService.patchFotoDipendente(id,foto);
    }
}
