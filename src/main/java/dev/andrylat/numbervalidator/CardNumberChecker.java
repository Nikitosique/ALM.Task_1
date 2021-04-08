package dev.andrylat.numbervalidator;

public class CardNumberChecker {

    public static CardStatus checkCardNumber(String cardNumber) {
        try {
            long cardNumberInt = Long.parseLong(cardNumber);
        } catch (NumberFormatException nfe) {
            return CardStatus.INVALID_CARD_NUMBER;
        }
        return CardStatus.VALID_CARD_NUMBER;
    }
}
