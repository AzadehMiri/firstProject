package org.example.model;

import java.math.BigDecimal;

/**
 * Deposit is a contract between the bank and the customer.
 * according to it, the customer provides a part of her money to the bank.
 * These contracts allow the bank to share the customer's money in the sectors that are recorded in the contract.
 * According to this contract, the bank will pay interest to the customer.
 * @author AzadehMiri
 */
public class Deposit implements Comparable<Deposit> {
    private String customerNumber;
    private String depositType;
    private String durationInDays;
    private String interestRate;
    private BigDecimal depositBalance;
    private BigDecimal interestPayed;

    public Deposit(String customerNumber, String depositType, String durationInDays, String interestRate, BigDecimal depositBalance) {
        this.customerNumber = customerNumber;
        this.depositType = depositType;
        this.durationInDays = durationInDays;
        this.interestRate = interestRate;
        this.depositBalance = depositBalance;
    }

    public Deposit() {
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(String durationInDays) {
        this.durationInDays = durationInDays;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getDepositBalance() {
        return depositBalance;
    }

    public void setDepositBalance(BigDecimal depositBalance) {
        this.depositBalance = depositBalance;
    }

    public BigDecimal getInterestPayed() {
        return interestPayed;
    }

    public void setInterestPayed(BigDecimal interestPayed) {
        this.interestPayed = interestPayed;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "customerNumber='" + customerNumber + '\'' +
                ", depositType='" + depositType + '\'' +
                ", durationInDays='" + durationInDays + '\'' +
                ", interestRate='" + interestRate + '\'' +
                ", depositBalance=" + depositBalance +
                ", interestPayed=" + interestPayed +
                '}';
    }

    @Override
    public int compareTo(Deposit deposit) {
        if (interestPayed.compareTo(deposit.interestPayed) == 0) {
            return 0;
        } else if (interestPayed.compareTo(deposit.interestPayed) < 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
