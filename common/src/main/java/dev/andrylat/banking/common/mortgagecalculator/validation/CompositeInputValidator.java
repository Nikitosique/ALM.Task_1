package dev.andrylat.banking.common.mortgagecalculator.validation;

import java.util.ArrayList;
import java.util.List;

public class CompositeInputValidator implements InputValidator {

    @Override
    public List<String> validate(InputData inputData) {
        List<String> failureMessages = new ArrayList<>();
        InputValidatorsProvider validatorsProvider = new InputValidatorsProvider();

        List<InputValidator> validatorList = validatorsProvider.getInputValidators();
        for (InputValidator validator : validatorList) {
            if (!validator.validate(inputData).isEmpty()) {
                failureMessages.addAll(validator.validate(inputData));
            }
        }

        return failureMessages;
    }

}
