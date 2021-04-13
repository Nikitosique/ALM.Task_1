package dev.andrylat.validation;

import org.junit.platform.commons.util.StringUtils;

public class NonDigitsValidator implements CardValidator {

    public static final String REGEX = "[\\d]+";
    public static final String ERROR_MESSAGE = "-> Card number should contain only digits\n";

    @Override
    public String validate(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return ERROR_MESSAGE;
        }

        if (cardNumber.matches(REGEX)) {
            return "";
        } else return ERROR_MESSAGE;
    }
}
