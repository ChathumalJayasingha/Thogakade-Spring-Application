package lk.ijse.spring.advisors;


import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {



    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return new ResponseEntity(new StandardResponse("500", "Error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        return new ResponseEntity(new StandardResponse("404", "Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity handleValidationException(ValidateException e) {
        return new ResponseEntity(new StandardResponse("400", "Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }





//    @ExceptionHandler(Exception.class)
//    public ResponseEntity exceptionHandler(Exception exception){
//        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity exceptionHandler(Exception exception){
//        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity exceptionNotFoundHandler(NotFoundException exception){
//        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
//    }
//    @ExceptionHandler(ValidateException.class)
//    public ResponseEntity exceptionValidationHandler(ValidateException exception){
//        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }


}
