package dev.andrylat.banking.mortgagecalculator.validation;

public class InputDataStorage {

    private String loanAmount;
    private String interestRate;
    private String termYears;

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getTermYears() {
        return termYears;
    }

    public void setTermYears(String termYears) {
        this.termYears = termYears;
    }

}
