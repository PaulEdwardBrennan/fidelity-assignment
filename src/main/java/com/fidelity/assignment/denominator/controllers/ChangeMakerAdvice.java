package com.fidelity.assignment.denominator.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ChangeMakerAdvice {

    @ExceptionHandler(Exception.class)
    public String changeMakerExceptionHandler(Exception e) {
        System.out.println("Hello from ChangeMakerAdvice.changeMakerExceptionHandler()");

        // TODO set up log file
        log.error(e.getMessage());

        return e.getMessage();
    }
}
