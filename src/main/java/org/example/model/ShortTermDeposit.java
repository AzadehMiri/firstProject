package org.example.model;

/**
 * It varies depending on the type of deposit.
 * This is a Short term deposit.
 * short-term deposit with an interest rate of 10%
 */
public class ShortTermDeposit extends Deposit {

    @Override
    public String getInterestRate() {
        return "10";
    }
}
