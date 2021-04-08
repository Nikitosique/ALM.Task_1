package dev.andrylat.numbervalidator;

import org.junit.platform.commons.util.StringUtils;

public class CardNumberIsEmpty {
    public static CardStatus checkForEmptiness(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return CardStatus.CARD_IS_EMPTY;
        }
        return CardStatus.CARD_IS_NOT_EMPTY;
    }
}
