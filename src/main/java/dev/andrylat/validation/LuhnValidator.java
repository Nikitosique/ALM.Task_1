package dev.andrylat.validation;

import org.junit.platform.commons.util.StringUtils;

public class LuhnValidator implements CardValidator {

    public static final String ERROR_MESSAGE = "-> Control sum is invalid\n";

    @Override
    public String validate(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return ERROR_MESSAGE;
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
        if (controlSum % 10 == 0) {
            return "";
        }
        return ERROR_MESSAGE;
    }

}

