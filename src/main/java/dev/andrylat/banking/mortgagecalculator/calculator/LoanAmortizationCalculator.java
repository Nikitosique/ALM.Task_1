package dev.andrylat.banking.mortgagecalculator.calculator;

import dev.andrylat.banking.mortgagecalculator.validation.InputDataStorage;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;

public class LoanAmortizationCalculator implements Calculator<List<Double>> {

    private static final int MONTHS_PER_YEAR = 12;
    private static final int BASE = 100;

    @Override
    public List<Double> calculate(InputDataStorage inputData) {
        double loanAmount = Double.parseDouble(inputData.getLoanAmount());
        double interestRate = Double.parseDouble(inputData.getInterestRate()) / BASE;
        int termYears = Integer.parseInt(inputData.getTermYears());

        List<Double> loanAmortizationData = new ArrayList<>();

        Calculator<Double> calculator = new MonthlyPaymentCalculator();
        double monthlyPayment = calculator.calculate(inputData);

        double interest, principal, balance;
        int termMonths = termYears * MONTHS_PER_YEAR;
        int currentMonth = 1;

        while (currentMonth <= termMonths) {
            interest = loanAmount * (interestRate / MONTHS_PER_YEAR);
            principal = monthlyPayment - interest;
            balance = loanAmount - principal > 0 ? (loanAmount - principal) : 0;

            loanAmortizationData.add((double) currentMonth);
            loanAmortizationData.add(Precision.round(interest, 2));
            loanAmortizationData.add(Precision.round(principal, 2));
            loanAmortizationData.add(Precision.round(balance, 2));

            loanAmount = balance;
            ++currentMonth;
        }

        return loanAmortizationData;
    }

}
