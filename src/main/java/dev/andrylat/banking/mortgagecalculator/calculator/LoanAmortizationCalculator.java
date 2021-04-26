package dev.andrylat.banking.mortgagecalculator.calculator;

import dev.andrylat.banking.mortgagecalculator.validation.InputData;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;

public class LoanAmortizationCalculator implements Calculator<List<ResultData>> {

    private static final int MONTHS_PER_YEAR = 12;
    private static final int BASE = 100;

    @Override
    public List<ResultData> calculate(InputData inputData) {
        double loanAmount = Double.parseDouble(inputData.getLoanAmount());
        double interestRate = Double.parseDouble(inputData.getInterestRate()) / BASE;
        int termYears = Integer.parseInt(inputData.getTermYears());

        Calculator<Double> calculator = new MonthlyPaymentCalculator();
        double monthlyPayment = calculator.calculate(inputData);

        return calculateData(loanAmount, interestRate, termYears, monthlyPayment);
    }

    private List<ResultData> calculateData(double loanAmount, double interestRate, int termYears, double monthlyPayment) {
        double interest, principal, balance;
        int termMonths = termYears * MONTHS_PER_YEAR;
        int currentMonth = 1;

        List<ResultData> loanAmortizationData = new ArrayList<>();

        while (currentMonth <= termMonths) {
            interest = loanAmount * (interestRate / MONTHS_PER_YEAR);
            principal = monthlyPayment - interest;
            balance = loanAmount - principal > 0 ? (loanAmount - principal) : 0;

            ResultData data = new ResultData();
            data.setMonth(currentMonth);
            data.setInterest(Precision.round(interest, 2));
            data.setPrincipal(Precision.round(principal, 2));
            data.setBalance(Precision.round(balance, 2));

            loanAmortizationData.add(data);

            loanAmount = balance;
            ++currentMonth;
        }

        return loanAmortizationData;
    }

}
