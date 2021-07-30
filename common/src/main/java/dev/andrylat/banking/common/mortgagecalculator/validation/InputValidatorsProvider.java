package dev.andrylat.banking.common.mortgagecalculator.validation;

import java.util.Arrays;
import java.util.List;

public class InputValidatorsProvider {

    private static final List<InputValidator> validators = Arrays.asList(
            new LoanAmountValidator(),
            new InterestRateValidator(),
            new TermYearsValidator()
    );

    List<InputValidator> getInputValidators() {
        return validators;
    }

}
