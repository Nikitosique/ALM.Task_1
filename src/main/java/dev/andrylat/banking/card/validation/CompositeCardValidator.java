package dev.andrylat.banking.card.validation;

import java.util.ArrayList;
import java.util.List;

public class CompositeCardValidator implements CardValidator {

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessages = new ArrayList<>();
        CardValidatorsStorage storage = new CardValidatorsStorage();

        List<CardValidator> validatorsList = storage.getCardNumberValidators();
        for (CardValidator validator : validatorsList) {
            if (!validator.validate(cardNumber).isEmpty()) {
                failureMessages.addAll(validator.validate(cardNumber));
            }
        }

        return failureMessages;
    }

}
