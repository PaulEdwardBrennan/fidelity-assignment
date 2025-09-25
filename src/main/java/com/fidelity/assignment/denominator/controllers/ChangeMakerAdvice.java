package com.fidelity.assignment.denominator.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ChangeMakerAdvice {

    @ExceptionHandler(Exception.class)
    public String changeMakerExceptionHandler(Exception e) {
        System.out.println("Hello from ChangeMakerAdvice.changeMakerExceptionHandler()");
        return e.getMessage();
    }
}
