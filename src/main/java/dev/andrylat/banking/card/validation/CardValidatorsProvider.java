package dev.andrylat.banking.card.validation;

import java.util.ArrayList;
import java.util.List;

public class CardValidatorsProvider {

    private static final List<CardValidator> validators = new ArrayList<>(List.of(
            new NonDigitsValidator(),
            new LengthValidator(),
            new LuhnValidator(),
            new PaymentSystemValidator()
    ));

    List<CardValidator> getCardNumberValidators() {
        return validators;
    }

}
