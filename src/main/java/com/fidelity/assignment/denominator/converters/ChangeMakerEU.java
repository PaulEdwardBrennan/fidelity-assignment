package com.fidelity.assignment.denominator.converters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * This class changes an amount of cents into the appropriate denominates of Euro notes and coins.
 *
 */
@Component
@Qualifier("EU")
public class ChangeMakerEU implements IChangeMaker {

    /* This ChangeMaker is for Euros */
    private static final String currency = "EU";

    private static int[] DENOMINATIONS = {
        50000, // €500 note
        20000, // €200 note
        10000, // €100 note
        5000,  // €50 note
        2000,  // €20 note
        1000,  // €10 note
        500,   // €5 note
        200,   // €2 coin
        100,   // €1 coin
        50,    // Fifty cent coin
        10,    // Ten cent coin
        20,    // Twenty cent coin
        5,     // Five cent coin
        2,     // Two cent coin
        1      // Cent coin
    };

    private static final String[] DENOMINATION_NAMES = {
        "five hundred euro note",
        "two hundred euro note",
        "hundred euro note",
        "fifty euro note",
        "twenty euro note",
        "ten euro note",
        "five euro note",
        "two euro coin",
        "one euro coin",
        "fifty cent coin",
        "twenty cent coin",
        "ten cent coin",
        "five cent coin",
        "two cent coin",
        "cent coin"
    };

    private static final String[] DENOMINATION_PLURALS = {
            "five hundred euro notes",
            "two hundred euro notes",
            "hundred euro notes",
            "fifty euro notes",
            "twenty euro notes",
            "ten euro notes",
            "five euro notes",
            "two euro coins",
            "one euro coins",
            "fifty cent coins",
            "twenty cent coins",
            "ten cent coins",
            "five cent coins",
            "two cent coins",
            "cent coins"
    };

    /**
     *
     * @param totalCents Amount in cents to denominate/change
     * @return A string detailing the currency denominations for the totalCents amount.
     */
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
