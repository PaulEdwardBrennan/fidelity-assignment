package com.fidelity.assignment.denominator.services;

import com.fidelity.assignment.denominator.converters.ChangeMakerUS;
import com.fidelity.assignment.denominator.converters.IChangeMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * This class acts as the service provider for breaking an amount in cents to the various denominations of
 * a currency.
 */
@Service
public class ChangeMakerService {

    /* This will do the work of denominating the cents. */
    private IChangeMaker changeMaker;

    /* This will validate the cents value input by the user. */
    private CentsValidator validator;

    @Autowired
    public ChangeMakerService(@Qualifier("USD") IChangeMaker changeMaker, CentsValidator validator) {

        // TODO Extend for other currencies
        // ChangeMakerService(List<IChangeMaker> changeMakers, CentsValidator validator)
        // this.changeMakers = changeMakers;
        // etc, etc....

        /* Constructor injection of the change maker and validator beans. */
        this.validator = validator;
        this.changeMaker = changeMaker;
    }

    public ChangeMakerDao denominate(int cents) {

        ChangeMakerDao dao = new ChangeMakerDao();

        if (validator.validate(cents)) {

            String changeAmounts = changeMaker.denominate(cents);

            dao.setChangeAmounts(changeAmounts);
            dao.setSuccess(true);
        }
        else {

            dao.setChangeAmounts(validator.getMessage());
            dao.setSuccess(false);

        }

        return dao;
    }
}
