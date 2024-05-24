package progettoSettimanale.progettou5w2d5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettoSettimanale.progettou5w2d5.dto.ComputerDto;
import progettoSettimanale.progettou5w2d5.dto.DispositivoDto;

import progettoSettimanale.progettou5w2d5.dto.SmartphoneDto;
import progettoSettimanale.progettou5w2d5.exception.DispositivoNonTrovatoException;
import progettoSettimanale.progettou5w2d5.model.Computer;
import progettoSettimanale.progettou5w2d5.model.Dispositivo;
import progettoSettimanale.progettou5w2d5.model.Smartphone;
import progettoSettimanale.progettou5w2d5.repository.DispositivoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public String saveDispositivo(DispositivoDto dispositivoDto){
        if(dispositivoDto instanceof ComputerDto computerDto){
            Computer computer = new Computer();
            computer.setNome(dispositivoDto.getNome());
            computer.setMarca(dispositivoDto.getMarca());
            computer.setStato(dispositivoDto.getStato());
            computer.setMonitor(computerDto.getMonitor());
            computer.setRam(computerDto.getRam());
            dispositivoRepository.save(computer);
            return "Il dispositivo "+ computerDto.getNome() + " è stato salvato con successo";
        } else  {
            SmartphoneDto smartphoneDto = (SmartphoneDto) dispositivoDto;
            Smartphone smartphone = new Smartphone();
            smartphone.setNome(dispositivoDto.getNome());
            smartphone.setMarca(dispositivoDto.getMarca());
            smartphone.setStato(dispositivoDto.getStato());
            smartphone.setMemoria(smartphoneDto.getMemoria());
            smartphone.setDualSim(smartphoneDto.isDualSim());
            dispositivoRepository.save(smartphone);
            return "Il dispositivo "+ smartphoneDto.getNome() + " è stato salvato con successo";
        }
    }

    /*public String saveDispositivo(DispositivoDto dispositivoDto) {
        Dispositivo dispositivo = dispositivoDto.toModel();
        dispositivoRepository.save(dispositivo);
        return "Il dispositivo " + dispositivo.getNome() + " è stato salvato con successo";
    }*/

    public List<Dispositivo> getAllDispositivi(){
       return dispositivoRepository.findAll();
    }

    public Optional<Dispositivo> getDispositivoById(int id){
        return dispositivoRepository.findById(id);
    }

    public Dispositivo updateDispositivo(int id, DispositivoDto dispositivoDto){
        Optional<Dispositivo> dispositivoOptional = getDispositivoById(id);
        if(dispositivoOptional.isPresent()){
            if(dispositivoDto instanceof ComputerDto computerDto){
                Computer computer = (Computer) dispositivoOptional.get();
                computer.setRam(computerDto.getRam());
                computer.setMonitor(computerDto.getMonitor());
                dispositivoRepository.save(computer);
                return computer;
            } else {
                SmartphoneDto smartphoneDto = (SmartphoneDto) dispositivoDto;
                Smartphone smartphone = (Smartphone) dispositivoOptional.get();
                smartphone.setMemoria(smartphoneDto.getMemoria());
                smartphone.setDualSim(smartphoneDto.isDualSim());
                dispositivoRepository.save(smartphone);
                return smartphone;
            }
        } else {
            throw new DispositivoNonTrovatoException("Il dispositivo non è stato trovato.");
        }
    }

    public String deleteDispositivo(int id){
        Optional<Dispositivo> dispositivoOptional = getDispositivoById(id);
        if(dispositivoOptional.isPresent()){
            dispositivoRepository.delete(dispositivoOptional.get());
            return "Dispositivo con id " + id + " è stato eliminato con successo.";
        } else {
            throw new DispositivoNonTrovatoException("Il dispositivo da eliminare non è stato trovato.");
        }
    }
}
