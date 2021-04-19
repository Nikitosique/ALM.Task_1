package dev.andrylat.banking.validation;

import java.util.ArrayList;
import java.util.List;

public class CompositeValidator implements CardValidator {

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessages = new ArrayList<>();
        ValidatorsList collector = new ValidatorsList();

        List<CardValidator> validatorsList = collector.getCardNumberValidators();
        for (CardValidator validator : validatorsList) {
            if (!validator.validate(cardNumber).isEmpty()) {
                failureMessages.addAll(validator.validate(cardNumber));
            }
        }

        return failureMessages;
    }

}
