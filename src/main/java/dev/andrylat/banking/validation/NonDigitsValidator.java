package dev.andrylat.banking.validation;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NonDigitsValidator implements CardValidator {

    private static final String DIGITS_REGEX = "[\\d]+";
    private static final String MESSAGE = "Card number should contain only digits";

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessage = new ArrayList<>();

        if (StringUtils.isBlank(cardNumber) || !cardNumber.matches(DIGITS_REGEX)) {
            failureMessage.add(MESSAGE);
        }

        return failureMessage;
    }

}
