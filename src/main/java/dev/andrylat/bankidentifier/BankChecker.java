package dev.andrylat.bankidentifier;

import java.util.ArrayList;
import java.util.List;

public class BankChecker {

    public static BankType checkBankType(String cardNumber) {
        if (cardNumber.charAt(0) == '4') {
            return BankType.VISA;
        }

        String firstTwoNumbers = cardNumber.substring(0, 2);
        List<String> masterCardIndexes = new ArrayList<>(List.of("51", "52", "53", "54", "55"));
        if (masterCardIndexes.contains(firstTwoNumbers)) {
            return BankType.MASTERCARD;
        }

        List<String> dinersClubIndexes = new ArrayList<>(List.of("36", "38"));
        if (dinersClubIndexes.contains(firstTwoNumbers)) {
            return BankType.DINERS_CLUB;
        }

        List<String> americanExpressIndexes = new ArrayList<>(List.of("34", "37"));
        if (americanExpressIndexes.contains(firstTwoNumbers)) {
            return BankType.AMERICAN_EXPRESS;
        }

        if ("35".equals(firstTwoNumbers)) {
            return BankType.JCB;
        }

        String firstFourNumbers = cardNumber.substring(0, 4);
        List<String> discoverIndexes = new ArrayList<>(List.of("6011", "65"));
        if (discoverIndexes.contains(firstTwoNumbers) || discoverIndexes.contains(firstFourNumbers)) {
            return BankType.DISCOVER;
        }

        return BankType.UNKNOWN;
    }
}
