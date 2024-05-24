package progettoSettimanale.progettou5w2d5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import progettoSettimanale.progettou5w2d5.model.ErrorModel;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CentralizedExceptions {

    @ExceptionHandler(DipendenteNonTrovatoException.class)
    public ResponseEntity<Object> dipendenteNonTrovatoHandler(DipendenteNonTrovatoException e) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMessaggio(e.getMessage());
        errorModel.setDataErrore(LocalDateTime.now());
        return new ResponseEntity<>(errorModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DispositivoNonTrovatoException.class)
    public ResponseEntity<Object> dispositivoNonTrovatoException(DispositivoNonTrovatoException e) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMessaggio(e.getMessage());
        errorModel.setDataErrore(LocalDateTime.now());
        return new ResponseEntity<>(errorModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DispositivoNonDisponibileException.class)
    public ResponseEntity<Object> dispositivoNonDisponibileHandler(DispositivoNonDisponibileException e) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMessaggio(e.getMessage());
        errorModel.setDataErrore(LocalDateTime.now());
        return new ResponseEntity<>(errorModel, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MyBadRequestException.class)
    public ResponseEntity<Object> myBadRequestException(MyBadRequestException e) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMessaggio(e.getMessage());
        errorModel.setDataErrore(LocalDateTime.now());
        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }
}
