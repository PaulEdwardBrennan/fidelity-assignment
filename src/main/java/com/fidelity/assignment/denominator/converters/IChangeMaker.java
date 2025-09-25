package com.fidelity.assignment.denominator.converters;

public interface IChangeMaker {

    /**
     * This method breaks the cents into note/bill and coins for the currency.
     * @param cents Amount in cents
     * @return A string representing the denomination breakdown for the cents.
     */
    public String denominate(int cents);

    /**
     *
     * @return A string that indicates the currency for the implementing ChangeMaker.
     */
    public String getCurrency();
}
