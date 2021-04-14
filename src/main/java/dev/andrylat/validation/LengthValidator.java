package dev.andrylat.validation;

import org.junit.platform.commons.util.StringUtils;

public class LengthValidator implements CardValidator {

    private static final int ALLOWED_LENGTH = 16;
    private static final String NON_DIGITS_REGEX = "[^0-9]+";
    private static final String VALIDATION_ERROR = "-> Card number's length should be 16 digits\n";

    @Override
    public boolean validate(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return false;
        }

        String cardNumberWithoutNonDigits = cardNumber.replaceAll(NON_DIGITS_REGEX, "");
        return cardNumberWithoutNonDigits.length() == ALLOWED_LENGTH;
    }

    @Override
    public String getValidationError() {
        return VALIDATION_ERROR;
    }

}
