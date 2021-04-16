package dev.andrylat.banking.validation;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LengthValidator implements CardValidator {

    private static final int ALLOWED_LENGTH = 16;
    private static final String NON_DIGITS_REGEX = "[^0-9]+";
    private static final String MESSAGE = "Card number's length should be 16 digits";

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessage = new ArrayList<>();

        if (StringUtils.isBlank(cardNumber)) {
            failureMessage.add(MESSAGE);
            return failureMessage;
        }

        String cardNumberWithoutNonDigits = cardNumber.replaceAll(NON_DIGITS_REGEX, "");
        if (cardNumberWithoutNonDigits.length() != ALLOWED_LENGTH) {
            failureMessage.add(MESSAGE);
        }

        return failureMessage;
    }
}
