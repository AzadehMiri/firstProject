package org.example.model;

/**
 * It varies depending on the type of deposit.
 * This is a long term deposit.
 * Long-term deposit with an interest rate of 20%
 */
public class LongTermDeposit extends Deposit {

    @Override
    public String getInterestRate() {
        return "20";
    }
}
