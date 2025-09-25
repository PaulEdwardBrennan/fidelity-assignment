package com.fidelity.assignment.denominator.controllers;

import com.fidelity.assignment.denominator.services.ChangeMakerDao;
import com.fidelity.assignment.denominator.services.ChangeMakerService;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/changemaker")
@CrossOrigin(origins = "*")
@Validated
public class ChangeMakerController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ChangeMakerService changeMakerService;

    @Autowired
    public ChangeMakerController(ChangeMakerService changeMakerService) {

        this.changeMakerService = changeMakerService;
    }

    /**
     *
     * @param cents Total amount of cents in the target currency.
     * @param currency The target currency.
     * @return String representing the cents split into note and coin denominations.
     */
    @GetMapping("/change/{cents}")
    public ResponseEntity<String> changeCents(@PathVariable @Min(1) int cents, @RequestParam String currency) {

        ChangeMakerDao dao = changeMakerService.denominate(cents);

        if (dao.isSuccess()) {
            return ResponseEntity.ok("You sent me " + cents + " cents. This breaks down to " + dao.getChangeAmounts() + " in " + currency);
        }
        else {

            return ResponseEntity.badRequest().body(dao.getChangeAmounts());
        }

    }
}
