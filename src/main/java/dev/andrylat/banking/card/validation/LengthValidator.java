package dev.andrylat.banking.card.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LengthValidator implements CardValidator {

    private static final int ALLOWED_LENGTH = 16;
    private static final String NON_DIGITS_REGEX = "[^0-9]+";
    private static final String MESSAGE = "Card number's length should be 16 digits";

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessages = new ArrayList<>();

        if (StringUtils.isBlank(cardNumber)) {
            failureMessages.add(MESSAGE);
            return failureMessages;
        }

        String cardNumberWithoutNonDigits = cardNumber.replaceAll(NON_DIGITS_REGEX, "");
        if (cardNumberWithoutNonDigits.length() != ALLOWED_LENGTH) {
            failureMessages.add(MESSAGE);
        }

        return failureMessages;
    }

}
