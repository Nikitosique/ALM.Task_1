package dev.andrylat.validation;

import org.junit.platform.commons.util.StringUtils;

public class LengthValidator implements CardValidator {

    public static final int ALLOWED_LENGTH = 16;
    public static final String REGEX = "[^0-9]+";
    public static final String ERROR_MESSAGE = "-> Card number's length should be 16 digits\n";

    @Override
    public String validate(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return ERROR_MESSAGE;
        }

        String cardNumberWithoutNonDigits = cardNumber.replaceAll(REGEX, "");
        if (cardNumberWithoutNonDigits.length() == ALLOWED_LENGTH) {
            return "";
        } else return ERROR_MESSAGE;
    }
}
