package dev.andrylat.banking.common.card.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LuhnValidator implements CardValidator {

    private static final String MESSAGE = "Control sum is invalid";

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessages = new ArrayList<>();

        if (StringUtils.isBlank(cardNumber) || !checkControlSum(cardNumber)) {
            failureMessages.add(MESSAGE);
            return failureMessages;
        }

        return failureMessages;
    }

    private boolean checkControlSum(String cardNumber) {
        int[] cardNumberArray = new int[cardNumber.length()];
        int temp = 0;
        int controlSum = 0;

        for (int i = 0; i < cardNumber.length(); i++) {
            cardNumberArray[i] = Character.getNumericValue(cardNumber.charAt(i));
        }

        for (int i = 0; i < cardNumberArray.length; i++) {
            if (i % 2 == 0) {
                temp = cardNumberArray[i] * 2;
                controlSum = controlSum + temp % 10;
                controlSum = controlSum + temp / 10;
            } else {
                controlSum = controlSum + cardNumberArray[i];
            }
        }

        return controlSum % 10 == 0;
    }

}

