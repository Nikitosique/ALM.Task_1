package dev.andrylat.validation;

import org.junit.platform.commons.util.StringUtils;

public class LuhnValidator implements CardValidator {

    private static final String VALIDATION_ERROR = "-> Control sum is invalid\n";

    @Override
    public boolean validate(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return false;
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
        return controlSum % 10 == 0;
    }

    @Override
    public String getValidationError() {
        return VALIDATION_ERROR;
    }

}

