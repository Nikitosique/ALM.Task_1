package dev.andrylat.banking.menu.operations;

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
import dev.andrylat.banking.utils.StringUtils;
import org.apache.commons.io.input.CloseShieldInputStream;

import java.util.List;
import java.util.Scanner;

public class MortgageCalculation implements Operation {

    @Override
    public void start() {
        try (Scanner scanner = new Scanner(new CloseShieldInputStream(System.in))) {
            InputData inputData = new InputData();

            System.out.println("Please, enter loan amount (USD):");
            String loanAmount = scanner.nextLine();
            loanAmount = StringUtils.replaceCommas(loanAmount);
            inputData.setLoanAmount(loanAmount);

            System.out.println("Please, enter interest rate value (Percents):");
            String interestRate = scanner.nextLine();
            interestRate = StringUtils.replaceCommas(interestRate);
            inputData.setInterestRate(interestRate);

            System.out.println("Please, enter loan term (Years):");
            String termYears = scanner.nextLine();
            termYears = StringUtils.replaceCommas(termYears);
            inputData.setTermYears(termYears);

            System.out.println(getResult(inputData));
        }
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
