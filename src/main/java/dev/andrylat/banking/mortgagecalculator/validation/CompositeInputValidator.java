package dev.andrylat.banking.mortgagecalculator.validation;

import java.util.ArrayList;
import java.util.List;

public class CompositeInputValidator implements InputValidator {

    @Override
    public List<String> validate(InputDataStorage inputData) {
        List<String> failureMessages = new ArrayList<>();
        InputValidatorsStorage validatorsStorage = new InputValidatorsStorage();

        List<InputValidator> validatorList = validatorsStorage.getInputValidators();
        for (InputValidator validator : validatorList) {
            if (!validator.validate(inputData).isEmpty()) {
                failureMessages.addAll(validator.validate(inputData));
            }
        }

        return failureMessages;
    }

}
