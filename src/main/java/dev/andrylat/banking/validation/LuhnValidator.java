package dev.andrylat.banking.validation;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LuhnValidator implements CardValidator {

    private static final String MESSAGE = "Control sum is invalid";

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessage = new ArrayList<>();

        if (StringUtils.isBlank(cardNumber)) {
            failureMessage.add(MESSAGE);
            return failureMessage;
        }

        int[] cardNumberArray = new int[cardNumber.length()];
        for (int i = 0; i < cardNumber.length(); i++) {
            cardNumberArray[i] = Character.getNumericValue(cardNumber.charAt(i));
        }
        int temp = 0;
        int controlSum = 0;
        for (int i = 0; i < cardNumberArray.length; i++) {
            if (i % 2 == 0) {
                temp = cardNumberArray[i] * 2;
                controlSum = controlSum + temp % 10;
                controlSum = controlSum + temp / 10;
            } else {
                controlSum = controlSum + cardNumberArray[i];
            }
        }
        if (controlSum % 10 != 0) {
            failureMessage.add(MESSAGE);
            return failureMessage;
        }

        return failureMessage;
    }

}

