package com.example.test_sber.controllers.advicecontroller;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j
public class AccountControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<?> allExceptionHandler(Exception ex){

        log.info(ex.getMessage());

        return new ResponseEntity<>(ex.getMessage() + " <- Вот тут ошибка", HttpStatus.BAD_REQUEST);
    }
}
