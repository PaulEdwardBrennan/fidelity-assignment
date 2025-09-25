package com.fidelity.assignment.denominator.services;

import org.springframework.stereotype.Component;

@Component
public class CentsValidator {


    String message;

    public boolean validate(int cents) {

        boolean isValid = true;

        if (cents < 0) {

            isValid = false;

            message = "Please enter a positive value for amount of cents";
        }

        return  isValid;
    }

    public String getMessage() {
        return message;
    }
}
