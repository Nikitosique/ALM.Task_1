package dev.andrylat.banking.mortgagecalculator.calculator;

import dev.andrylat.banking.mortgagecalculator.validation.InputDataStorage;
import org.apache.commons.math3.util.Precision;

public class MonthlyPaymentCalculator implements Calculator<Double> {

    private static final int MONTHS_PER_YEAR = 12;
    private static final int BASE = 100;

    @Override
    public Double calculate(InputDataStorage inputData) {
        double loanAmount = Double.parseDouble(inputData.getLoanAmount());
        double interestRate = Double.parseDouble(inputData.getInterestRate()) / BASE;
        int termYears = Integer.parseInt(inputData.getTermYears());

        double coefficient = Math.pow((1 + interestRate / MONTHS_PER_YEAR), MONTHS_PER_YEAR * termYears);
        double monthlyPayment = ((loanAmount * (interestRate / MONTHS_PER_YEAR) * coefficient) / (coefficient - 1));

        return Precision.round(monthlyPayment, 2);
    }

}
