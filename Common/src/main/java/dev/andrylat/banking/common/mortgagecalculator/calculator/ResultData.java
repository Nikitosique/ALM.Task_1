package dev.andrylat.banking.common.mortgagecalculator.calculator;

import static java.lang.Double.doubleToLongBits;

public class ResultData {

    private static final int PRIME_ODD_NUMBER = 31;
    private static final int BITS_NUMBER = 32;

    private int month;
    private double interest;
    private double principal;
    private double balance;

    public ResultData() {
    }

    public ResultData(int month, double interest, double principal, double balance) {
        this.month = month;
        this.interest = interest;
        this.principal = principal;
        this.balance = balance;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof ResultData)) {
            return false;
        }

        ResultData data = (ResultData) other;

        return month == data.month &&
                interest == data.interest &&
                principal == data.principal &&
                balance == data.balance;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = PRIME_ODD_NUMBER * result + month;

        long interestBits = doubleToLongBits(interest);
        result = PRIME_ODD_NUMBER * result + (int) (interestBits ^ (interestBits >>> BITS_NUMBER));

        long principalBits = doubleToLongBits(principal);
        result = PRIME_ODD_NUMBER * result + (int) (principalBits ^ (principalBits >>> BITS_NUMBER));

        long balanceBits = doubleToLongBits(balance);
        result = PRIME_ODD_NUMBER * result + (int) (balanceBits ^ (balanceBits >>> 32));

        return result;
    }

}
