package dev.andrylat.banking.mortgagecalculator.validation;

import java.util.ArrayList;
import java.util.List;

public class InputValidatorsProvider {

    private static final List<InputValidator> validators = new ArrayList<>(List.of(
            new LoanAmountValidator(),
            new InterestRateValidator(),
            new TermYearsValidator()
    ));

    List<InputValidator> getInputValidators() {
        return validators;
    }

}
