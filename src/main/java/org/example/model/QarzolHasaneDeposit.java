package org.example.model;

/**
 * It varies depending on the type of deposit.
 * This is a QarzolHasane deposit.
 * QarzolHasane deposit with an interest rate of 0%
 */
public class QarzolHasaneDeposit extends Deposit {

    @Override
    public String getInterestRate() {
        return "0";
    }
}
