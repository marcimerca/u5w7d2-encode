package progettoSettimanale.progettou5w2d5.service;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import progettoSettimanale.progettou5w2d5.dto.DipendenteDto;
import progettoSettimanale.progettou5w2d5.enums.Stato;
import progettoSettimanale.progettou5w2d5.exception.DipendenteNonTrovatoException;
import progettoSettimanale.progettou5w2d5.model.Dipendente;
import progettoSettimanale.progettou5w2d5.repository.DipendenteRepository;
import progettoSettimanale.progettou5w2d5.repository.DispositivoRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public String saveDipendente(DipendenteDto dipendenteDto) {
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setEmail(dipendenteDto.getEmail());
        dipendente.setUsername(dipendenteDto.getEmail());
        dipendenteRepository.save(dipendente);
        //Parte extra: ho aggiunto invio automatico della mail quando si crea un dipendente
        sendMail(dipendente.getEmail());
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
            Dipendente dipendente = dipendenteOptional.get();

            if (!dipendente.getDispositivi().isEmpty()) {
                dipendente.getDispositivi().stream().forEach(dispositivo -> dispositivo.setStato(Stato.DISPONIBILE));
                dipendente.getDispositivi().stream().forEach(dispositivo -> dispositivo.setDipendente(null));
            }
            dipendenteRepository.delete(dipendenteOptional.get());
            return "Il dipendente con id " + id + " è stato eliminato con successo.";
        } else {
            throw new DipendenteNonTrovatoException("Il dipendente con id " + id + " non è stato trovato");
        }


    }

    public String patchFotoDipendente(int id, MultipartFile foto) throws IOException {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);
        if (dipendenteOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setFoto(url);
            dipendenteRepository.save(dipendente);
            return "Foto con url " + url + " salvata e associata correttamente al dipendente con id " + id;
        } else {
            throw new DipendenteNonTrovatoException("Il dipendente con id " + id + " non è stato trovato");
        }
    }


    //Parte extra: ho aggiunto invio automatico della mail quando si crea un dipendente

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione");
        message.setText("Registrazione al servizio rest avvenuta con successo");


        javaMailSender.send(message);
    }


}
