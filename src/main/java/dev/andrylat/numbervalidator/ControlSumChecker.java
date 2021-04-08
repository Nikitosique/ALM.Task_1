package dev.andrylat.numbervalidator;

public class ControlSumChecker {

    public static CardStatus checkControlSum(String cardNumber) {
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
            return CardStatus.VALID_CONTROL_SUM;
        }
        return CardStatus.INVALID_CONTROL_SUM;
    }
}