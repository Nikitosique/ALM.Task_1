package dev.andrylat.numbervalidator;

public class LengthChecker {

    public static CardStatus checkLength(String cardNumber) {
        if (cardNumber.length() != 16) {
            return CardStatus.INVALID_LENGTH;
        }
        return CardStatus.VALID_LENGTH;
    }
}
