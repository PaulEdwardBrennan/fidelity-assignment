package com.fidelity.assignment.denominator.services;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class acts as the Data Access Object (DAO) for the cents breakdown in the currency denominations.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChangeMakerDao {

    /* The cent amount was successfully converted to the appropriate currency change amounts. */
    private boolean isSuccess;

    /* String representing the currency change amounts. */
    private String changeAmounts;
}
