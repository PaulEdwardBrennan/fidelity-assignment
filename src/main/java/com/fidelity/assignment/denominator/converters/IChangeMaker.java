package com.fidelity.assignment.denominator.converters;

/**
 * Classes implementing this interface will change an amount of
 * cents into the appropriate denomination for a particular currency such as US dollars or Euros.
 */
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
    public String getCurrency(); // TODO Future enhancement. Not implemented yet.
}
