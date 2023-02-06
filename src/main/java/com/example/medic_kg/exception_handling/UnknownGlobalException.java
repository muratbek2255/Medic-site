package com.example.medic_kg.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UnknownGlobalException {
    @ExceptionHandler
    public ResponseEntity<IncorrectUnknownData> handleException(NoSuchUnknownException exception) {
        IncorrectUnknownData data = new IncorrectUnknownData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    //Отловка вообще всех исключений
    @ExceptionHandler
    public ResponseEntity<IncorrectUnknownData> handleException(Exception exception) {
        IncorrectUnknownData data = new IncorrectUnknownData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
