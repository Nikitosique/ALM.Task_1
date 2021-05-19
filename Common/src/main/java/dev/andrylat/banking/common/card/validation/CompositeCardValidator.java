package dev.andrylat.banking.common.card.validation;

import java.util.ArrayList;
import java.util.List;

public class CompositeCardValidator implements CardValidator {

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessages = new ArrayList<>();
        CardValidatorsProvider provider = new CardValidatorsProvider();

        List<CardValidator> validatorsList = provider.getCardNumberValidators();
        for (CardValidator validator : validatorsList) {
            if (!validator.validate(cardNumber).isEmpty()) {
                failureMessages.addAll(validator.validate(cardNumber));
            }
        }

        return failureMessages;
    }

}
