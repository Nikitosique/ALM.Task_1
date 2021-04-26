package dev.andrylat.banking.operations;

import dev.andrylat.banking.mortgagecalculator.calculator.Calculator;
import dev.andrylat.banking.mortgagecalculator.calculator.LoanAmortizationCalculator;
import dev.andrylat.banking.mortgagecalculator.calculator.MonthlyPaymentCalculator;
import dev.andrylat.banking.mortgagecalculator.calculator.ResultData;
import dev.andrylat.banking.mortgagecalculator.messageformatter.FailureMessageFormatter;
import dev.andrylat.banking.mortgagecalculator.messageformatter.LoanAmortizationInfoFormatter;
import dev.andrylat.banking.mortgagecalculator.messageformatter.MessageFormatter;
import dev.andrylat.banking.mortgagecalculator.messageformatter.MonthlyPaymentInfoFormatter;
import dev.andrylat.banking.mortgagecalculator.validation.CompositeInputValidator;
import dev.andrylat.banking.mortgagecalculator.validation.InputData;
import dev.andrylat.banking.mortgagecalculator.validation.InputValidator;
import dev.andrylat.banking.utils.CommasReplacer;

import java.util.List;
import java.util.Scanner;

public class MortgageCalculation implements Operation {

    @Override
    public void startOperation() {
        Scanner scanner = new Scanner(System.in);
        InputData inputData = new InputData();

        System.out.println("Please, enter loan amount (USD):");
        String loanAmount = scanner.nextLine();
        loanAmount = CommasReplacer.replace(loanAmount);
        inputData.setLoanAmount(loanAmount);

        System.out.println("Please, enter interest rate value (Percents):");
        String interestRate = scanner.nextLine();
        interestRate = CommasReplacer.replace(interestRate);
        inputData.setInterestRate(interestRate);

        System.out.println("Please, enter loan term (Years):");
        String termYears = scanner.nextLine();
        termYears = CommasReplacer.replace(termYears);
        inputData.setTermYears(termYears);

        System.out.println(getResult(inputData));
    }

    public String getResult(InputData inputData) {
        InputValidator validator = new CompositeInputValidator();
        List<String> failureMessages = validator.validate(inputData);

        if (failureMessages.isEmpty()) {
            return performCalculation(inputData);
        } else {
            MessageFormatter<List<String>> formatter = new FailureMessageFormatter();
            return formatter.formatMessage(failureMessages);
        }
    }

    private String performCalculation(InputData inputData) {
        StringBuilder result = new StringBuilder();

        Calculator<Double> monthlyPaymentCalculator = new MonthlyPaymentCalculator();
        double monthlyPayment = monthlyPaymentCalculator.calculate(inputData);
        MessageFormatter<Double> monthlyPaymentInfoFormatter = new MonthlyPaymentInfoFormatter();
        result.append(monthlyPaymentInfoFormatter.formatMessage(monthlyPayment));

        Calculator<List<ResultData>> loanAmortizationCalculator = new LoanAmortizationCalculator();
        List<ResultData> loanAmortizationData = loanAmortizationCalculator.calculate(inputData);
        MessageFormatter<List<ResultData>> loanAmortizationFormatter = new LoanAmortizationInfoFormatter();
        result.append(loanAmortizationFormatter.formatMessage(loanAmortizationData));

        return result.toString();
    }

}
