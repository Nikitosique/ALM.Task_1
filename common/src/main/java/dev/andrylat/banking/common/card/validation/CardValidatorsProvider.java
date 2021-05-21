package dev.andrylat.banking.common.card.validation;

import java.util.Arrays;
import java.util.List;

public class CardValidatorsProvider {

    private static final List<CardValidator> validators = Arrays.asList(
            new NonDigitsValidator(),
            new LengthValidator(),
            new LuhnValidator(),
            new PaymentSystemValidator()
    );

    List<CardValidator> getCardNumberValidators() {
        return validators;
    }

}
