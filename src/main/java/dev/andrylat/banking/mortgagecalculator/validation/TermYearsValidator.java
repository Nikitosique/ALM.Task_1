package dev.andrylat.banking.mortgagecalculator.validation;

import java.util.ArrayList;
import java.util.List;

public class TermYearsValidator implements InputValidator {

    private static final int MIN_TERM = 1;
    private static final int MAX_TERM = 30;
    private static final String NON_DIGITS = "Loan term: you should enter only integers";
    private static final String INCORRECT_VALUE = "Loan term: this value is out of range [1 year - 30 years]";

    @Override
    public List<String> validate(InputDataStorage storage) {
        List<String> failureMessages = new ArrayList<>();

        String termYears = storage.getTermYears();

        try {
            int termYearsInt = Integer.parseInt(termYears);
            if (termYearsInt < MIN_TERM || termYearsInt > MAX_TERM) {
                failureMessages.add(INCORRECT_VALUE);
            }
        } catch (NullPointerException | NumberFormatException exception) {
            failureMessages.add(NON_DIGITS);
        }

        return failureMessages;
    }
}
