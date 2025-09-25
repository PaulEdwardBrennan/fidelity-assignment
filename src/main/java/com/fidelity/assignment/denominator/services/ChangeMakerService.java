package com.fidelity.assignment.denominator.services;

import com.fidelity.assignment.denominator.converters.ChangeMakerUS;
import com.fidelity.assignment.denominator.converters.IChangeMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChangeMakerService {

    private IChangeMaker changeMaker;
    private CentsValidator validator;

    @Autowired
    public ChangeMakerService(@Qualifier("USD") IChangeMaker changeMaker, CentsValidator validator) {

        this.validator = validator;
        //this.changeMaker = new ChangeMakerUS();
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
