package com.fidelity.assignment.denominator.converters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * This class changes an amount of cents into the appropriate denominates of US dollar notes and coins.
 *
 */
@Component
@Qualifier("USD")
public class ChangeMakerUS implements IChangeMaker {

    /* This ChangeMaker is for US dollars */
    private static final String currency = "USD";

    private static int[] DENOMINATIONS = {
        10000, // $100 bill
        5000,  // $50 bill
        2000,  // $20 bill
        1000,  // $10 bill
        500,   // $5  bill
        100,   // $1  bill
        25,    // Quarter
        10,    // Dime
        5,     // Nickel
        1      // Cent
    };

    private static final String[] DENOMINATION_NAMES = {
        "hundred dollar bill",
        "fifty dollar bill",
        "twenty dollar bill",
        "ten dollar bill",
        "five dollar bill",
        "dollar bill",
        "quarter",
        "dime",
        "nickel",
        "cent"
    };

    private static final String[] DENOMINATION_PLURALS = {
        "hundred dollar bills",
        "fifty dollar bills",
        "twenty dollar bills",
        "ten dollar bills",
        "five dollar bills",
        "dollar bills",
        "quarters",
        "dimes",
        "nickels",
        "cents"
    };

    /**
     *
     * @param totalCents Amount in cents to denominate/change
     * @return A string detailing the currency denominations for the totalCents amount.
     */
    @Override
    public String denominate(int totalCents) {

        StringBuilder result = new StringBuilder();
        int remainingAmount = totalCents;
        boolean isFirst = true;

        for (int i = 0; i < DENOMINATIONS.length; i++) {

            int count = remainingAmount / DENOMINATIONS[i];

            if (count > 0) {

                if (!isFirst) {

                    result.append(", ");
                }

                result.append(count);
                result.append(" ");

                /* Get the text for the denomination. It can be singular or plural. */
                if (count == 1) {

                    result.append(DENOMINATION_NAMES[i]);
                }
                else {

                    result.append(DENOMINATION_PLURALS[i]);
                }

                remainingAmount %= DENOMINATIONS[i];

                isFirst = false;
            }
        }

        return result.toString();
    }

    @Override
    public String getCurrency() {
        return currency;
    }
}
