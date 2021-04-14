package dev.andrylat.validation;

import org.junit.platform.commons.util.StringUtils;

public class NonDigitsValidator implements CardValidator {

    private static final String DIGITS_REGEX = "[\\d]+";
    private static final String VALIDATION_ERROR = "-> Card number should contain only digits\n";

    @Override
    public boolean validate(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return false;
        }
        return cardNumber.matches(DIGITS_REGEX);
    }

    public String getValidationError() {
        return VALIDATION_ERROR;
    }
}
