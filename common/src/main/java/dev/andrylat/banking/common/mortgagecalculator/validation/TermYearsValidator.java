package dev.andrylat.banking.common.mortgagecalculator.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TermYearsValidator implements InputValidator {

    private static final int MIN_TERM = 1;
    private static final int MAX_TERM = 30;
    private static final String NON_DIGITS = "Loan term: you should enter only integers";
    private static final String INCORRECT_VALUE = "Loan term: this value is out of range [1 year - 30 years]";

    @Override
    public List<String> validate(InputData inputData) {
        List<String> failureMessages = new ArrayList<>();

        String termYears = inputData.getTermYears();

        if (StringUtils.isBlank(termYears)) {
            failureMessages.add(NON_DIGITS);
            return failureMessages;
        }

        try {
            int termYearsInt = Integer.parseInt(termYears);
            if (termYearsInt < MIN_TERM || termYearsInt > MAX_TERM) {
                failureMessages.add(INCORRECT_VALUE);
            }
        } catch (NumberFormatException exception) {
            failureMessages.add(NON_DIGITS);
        }

        return failureMessages;
    }

}
