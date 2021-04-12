package dev.andrylat.cardchecker;

import org.junit.platform.commons.util.StringUtils;

public class NonDigitsChecker implements CardChecker {

    @Override
    public boolean check(String cardNumber) {

        if (StringUtils.isBlank(cardNumber)) {
            return false;
        }

        String cardNumberWithoutNonDigits = cardNumber.replaceAll("[^0-9]+", "");
        return cardNumber.length() == cardNumberWithoutNonDigits.length();
    }
}
