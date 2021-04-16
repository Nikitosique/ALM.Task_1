package dev.andrylat.banking.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidatorsCollector {

    public List<CardValidator> getCardNumberValidators() {
        List<CardValidator> validators = new ArrayList<>();

        validators.add(new NonDigitsValidator());
        validators.add(new LengthValidator());
        validators.add(new LuhnValidator());
        validators.add(new PaymentSystemValidator());

        return validators;
    }

}
