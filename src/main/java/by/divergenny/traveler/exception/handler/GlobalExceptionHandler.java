package by.divergenny.traveler.exception.handler;

import by.divergenny.traveler.exception.BaseException;
import by.divergenny.traveler.exception.ErrorData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.bind.ValidationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorData> handleException(BaseException exception) {
        ErrorData data = new ErrorData(exception.getMessage());
        log.error("Exception: " + data.getMessage());
        return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorData> handleException(Exception exception) {
        ErrorData data = new ErrorData(exception.getMessage());
        log.error("Exception: " + data.getMessage());
        return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorData> handleException(ValidationException exception) {
        ErrorData data = new ErrorData(exception.getMessage());
        log.error("Validation Exception: " + data.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

}
