package dev.andrylat.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidatorsCollector {
    public List<CardValidator> collectValidators() {
        List<CardValidator> validators = new ArrayList<>();
        validators.add(new NonDigitsValidator());
        validators.add(new LengthValidator());
        validators.add(new LuhnValidator());
        return validators;
    }
}
