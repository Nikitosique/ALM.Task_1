package dev.andrylat.banking.mortgagecalculator.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class InterestRateValidator implements InputValidator {

    private static final double MIN_INTEREST_RATE = 0.00d;
    private static final double MAX_INTEREST_RATE = 100.00d;
    private static final String NON_DIGITS = "Interest rate: you should enter only numbers";
    private static final String INCORRECT_VALUE = "Interest rate: this value is out of range [0% - 100%]";

    @Override
    public List<String> validate(InputData inputData) {
        List<String> failureMessages = new ArrayList<>();

        String interestRate = inputData.getInterestRate();

        if (StringUtils.isBlank(interestRate)) {
            failureMessages.add(NON_DIGITS);
            return failureMessages;
        }

        try {
            double interestRateDouble = Double.parseDouble(interestRate);
            if (interestRateDouble < MIN_INTEREST_RATE || interestRateDouble > MAX_INTEREST_RATE) {
                failureMessages.add(INCORRECT_VALUE);
            }
        } catch (NumberFormatException exception) {
            failureMessages.add(NON_DIGITS);
        }

        return failureMessages;
    }

}
