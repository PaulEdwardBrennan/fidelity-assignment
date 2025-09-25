package com.fidelity.assignment.denominator.services;

public class ChangeMakerDao {



    /* The cent amount was successfully converted to the appropriate currency change amounts. */
    private boolean isSuccess;

    /* String representing the currency change amounts. */
    private String changeAmounts;

    public ChangeMakerDao() {}

    public ChangeMakerDao(boolean success, String changeAmounts) {

        this.isSuccess = success;
        this.changeAmounts = changeAmounts;
    }

    public boolean isSuccess() {

        return isSuccess;
    }

    public void setSuccess(boolean success) {


        isSuccess = success;
    }

    public String getChangeAmounts() {

        return changeAmounts;
    }

    public void setChangeAmounts(String changeAmounts) {

        this.changeAmounts = changeAmounts;
    }
}
