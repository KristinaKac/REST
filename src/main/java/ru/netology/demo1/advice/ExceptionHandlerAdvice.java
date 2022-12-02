package ru.netology.demo1.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.demo1.exception.InvalidCredentials;
import ru.netology.demo1.exception.UnauthorizedUser;

@RestControllerAdvice()
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invCred(InvalidCredentials i){
        return new ResponseEntity<>("User name or password is empty", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unaUser(UnauthorizedUser i){
        return new ResponseEntity<>("Unknown user ", HttpStatus.UNAUTHORIZED);
    }
}
