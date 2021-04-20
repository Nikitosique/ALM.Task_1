package dev.andrylat.banking.mortgagecalculator.validation;

import java.util.ArrayList;
import java.util.List;

public class InputValidatorsStorage {

    private static final List<InputValidator> validators = new ArrayList<>(List.of(
            new LoanAmountValidator(),
            new InterestRateValidator(),
            new TermYearsValidator()
    ));

    public List<InputValidator> getInputValidators() {
        return validators;
    }

}
