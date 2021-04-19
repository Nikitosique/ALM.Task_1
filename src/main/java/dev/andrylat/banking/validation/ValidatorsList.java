package dev.andrylat.banking.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidatorsList {

    private static final List<CardValidator> validators = new ArrayList<>(List.of(
            new NonDigitsValidator(),
            new LengthValidator(),
            new LuhnValidator(),
            new PaymentSystemValidator()
    ));

    public List<CardValidator> getCardNumberValidators() {
        return validators;
    }

}
