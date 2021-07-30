package dev.andrylat.banking.common.mortgagecalculator.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LoanAmountValidator implements InputValidator {

    private static final double MIN_LOAN_AMOUNT = 1.00d;
    private static final String NON_DIGITS = "Loan Amount: you should enter only numbers";
    private static final String INCORRECT_VALUE = "Loan Amount: this value is less than the minimum (1 USD)";

    @Override
    public List<String> validate(InputData inputData) {
        List<String> failureMessages = new ArrayList<>();

        String loanAmount = inputData.getLoanAmount();

        if (StringUtils.isBlank(loanAmount)) {
            failureMessages.add(NON_DIGITS);
            return failureMessages;
        }

        try {
            double loanAmountDouble = Double.parseDouble(loanAmount);
            if (loanAmountDouble < MIN_LOAN_AMOUNT) {
                failureMessages.add(INCORRECT_VALUE);
            }
        } catch (NumberFormatException exception) {
            failureMessages.add(NON_DIGITS);
        }

        return failureMessages;
    }

}


