package progettoSettimanale.progettou5w2d5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptions {

    @ExceptionHandler(DipendenteNonTrovatoException.class)
    public ResponseEntity<Object> dipendenteNonTrovatoHandler(DipendenteNonTrovatoException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DispositivoNonTrovatoException.class)
    public ResponseEntity<Object> dispositivoNonTrovatoException(DispositivoNonTrovatoException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
}
