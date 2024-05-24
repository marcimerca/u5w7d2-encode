package progettoSettimanale.progettou5w2d5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import progettoSettimanale.progettou5w2d5.dto.DispositivoDto;
import progettoSettimanale.progettou5w2d5.exception.DispositivoNonTrovatoException;
import progettoSettimanale.progettou5w2d5.exception.MyBadRequestException;
import progettoSettimanale.progettou5w2d5.model.Dispositivo;
import progettoSettimanale.progettou5w2d5.service.DispositivoService;

import java.util.List;
import java.util.Optional;

@RestController
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("/dispositivi")
    public String saveDispositivo(@RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new MyBadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(s1, s2)->s1+s2));
        }
        return dispositivoService.saveDispositivo(dispositivoDto);
    }

    @GetMapping("/dispositivi")
    public List<Dispositivo> getAllDispositivi(){
        return dispositivoService.getAllDispositivi();
    }

    @GetMapping("/dispositivi/{id}")
    public Dispositivo getDispositivoById( @PathVariable int id){
       Optional<Dispositivo> dispositivoOptional = dispositivoService.getDispositivoById(id);
       if(dispositivoOptional.isPresent()){
           return dispositivoOptional.get();
       } else {
           throw new DispositivoNonTrovatoException("Il dispositivo con id "+ id + " non è stato trovato.");
       }
    }

    @PutMapping("/dispositivi/{id}")
    public Dispositivo updateDispositivo( @PathVariable int id, @RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new MyBadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(s1,s2)->s1+s2));
        }
        return dispositivoService.updateDispositivo(id,dispositivoDto);
    }

    @DeleteMapping("/dispositivi/{id}")
    public String deleteDispositivo( @PathVariable int id){
        return dispositivoService.deleteDispositivo(id);
    }

    @PatchMapping("/dispositivi/{idDispositivo}/{idDipendente}")
    public String patchDispositivoDipendente( @PathVariable int idDispositivo, @PathVariable int idDipendente){
        return dispositivoService.patchDispositivoDipendente(idDispositivo,idDipendente);
    }
}
